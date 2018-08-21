package com.eshop.serviceweb.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eshop.serviceweb.common.Constants;
import com.eshop.serviceweb.common.model.ResultEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.impl.DefaultHeader;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * APP登录Token的生成和解析
 *
 */
public class JwtTokenUtil {

    /** token秘钥，请勿泄露，请勿随便修改*/
    public static final String SECRET = "qwer";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static CompressionCodecResolver CODECRESOLVER = new DefaultCompressionCodecResolver();
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
    /**
     * JWT生成Token.<br/>
     *
     * JWT构成: header, payload, signature
     *
     * @param user_id
     *            登录成功后用户user_id, 参数user_id不可传空
     */
    public static String createToken(String userId,int expire) throws Exception {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, expire);
        Date expiresDate = nowTime.getTime();
        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:Web}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "Web").withClaim("user_id", null == userId ? null : userId)
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws Exception{
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        jwt = verifier.verify(token);
        log.info("token校验成功！");
        return jwt.getClaims();
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static Long getAppUID(String token) throws Exception{
        Map<String, Claim> claims = verifyToken(token);
        Claim user_id_claim = claims.get("userId");
        if (null == user_id_claim || StringUtils.isEmpty(user_id_claim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
        }
        return Long.valueOf(user_id_claim.asString());
    }

    public static void main(String[] args){
        try {
            long start = System.currentTimeMillis();
            String str = createToken("123",20);
            System.out.println("token is:"+str);
            //System.out.println("value is:"+verifyToken(str));
            System.out.println("time:"+(System.currentTimeMillis()-start));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",
//                    new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            final int KEY_SIZE = 256;// 没什么好说的了，这个值关系到块加密的大小，可以更改，但是不要太大，否则效率会低
//            keyPairGen.initialize(KEY_SIZE, new SecureRandom());
//            KeyPair keyPair = keyPairGen.generateKeyPair();
//            System.out.println("1:"+keyPair.getPrivate().getEncoded());
//            System.out.println("2:"+keyPair.getPublic());
//            System.out.println("3:"+keyPair.getPrivate().getFormat());
//            System.out.println("4:"+keyPair.getPrivate().toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 解析JWT的Payload
     */
    public static String parseJwtPayload(String jwt){
        Assert.hasText(jwt, "JWT String argument cannot be null or empty.");
        String base64UrlEncodedHeader = null;
        String base64UrlEncodedPayload = null;
        String base64UrlEncodedDigest = null;
        int delimiterCount = 0;
        StringBuilder sb = new StringBuilder(128);
        for (char c : jwt.toCharArray()) {
            if (c == '.') {
                CharSequence tokenSeq = io.jsonwebtoken.lang.Strings.clean(sb);
                String token = tokenSeq!=null?tokenSeq.toString():null;

                if (delimiterCount == 0) {
                    base64UrlEncodedHeader = token;
                } else if (delimiterCount == 1) {
                    base64UrlEncodedPayload = token;
                }

                delimiterCount++;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (delimiterCount != 2) {
            String msg = "JWT strings must contain exactly 2 period characters. Found: " + delimiterCount;
            throw new MalformedJwtException(msg);
        }
        if (sb.length() > 0) {
            base64UrlEncodedDigest = sb.toString();
        }
        if (base64UrlEncodedPayload == null) {
            throw new MalformedJwtException("JWT string '" + jwt + "' is missing a body/payload.");
        }
        // =============== Header =================
        Header header = null;
        CompressionCodec compressionCodec = null;
        if (base64UrlEncodedHeader != null) {
            String origValue = TextCodec.BASE64URL.decodeToString(base64UrlEncodedHeader);
            Map<String, Object> m = readValue(origValue);
            if (base64UrlEncodedDigest != null) {
                header = new DefaultJwsHeader(m);
            } else {
                header = new DefaultHeader(m);
            }
            compressionCodec = CODECRESOLVER.resolveCompressionCodec(header);
        }
        // =============== Body =================
        String payload;
        if (compressionCodec != null) {
            byte[] decompressed = compressionCodec.decompress(TextCodec.BASE64URL.decode(base64UrlEncodedPayload));
            payload = new String(decompressed, io.jsonwebtoken.lang.Strings.UTF_8);
        } else {
            payload = TextCodec.BASE64URL.decodeToString(base64UrlEncodedPayload);
        }
        return payload;
    }

    public static Map<String, Object> readValue(String val) {
        try {
            return MAPPER.readValue(val, Map.class);
        } catch (IOException e) {
            throw new MalformedJwtException("Unable to read JSON value: " + val, e);
        }
    }

    /**
     * 分割字符串进SET
     */
    public static Set<String> split(String str) {
        return split(str, ",");
    }

    /**
     * 分割字符串进SET
     */
    public static Set<String> split(String str, String separator) {

        Set<String> set = new LinkedHashSet();
        if (StringUtils.isEmpty(str))
            return set;
        for (String s : str.split(separator)) {
            set.add(s);
        }
        return set;
    }

    /**
     * JSON响应
     */
    private static void respondJson(HttpServletResponse response, ResultEntity<String> resultEntity) {
        if(null == resultEntity){
            resultEntity = new ResultEntity<String>();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String json = new ObjectMapper().writeValueAsString(resultEntity);
            out.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }

    /**
     * REST失败响应
     */
    public static void restFailed(HttpServletResponse response, ResultEntity<String> resultEntity) {
        respondJson(response,resultEntity);
    }

    public static String createToken(String userId) throws Exception {
        return createToken(userId,Constants.JWT_TOKEN_EXPIRE_TIME);
    }
}