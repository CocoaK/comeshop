package com.eshop.serviceapp.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.eshop.serviceapp.common.annotation.Decrypt;
import com.eshop.serviceapp.common.annotation.Encrypt;
import com.sun.jersey.core.util.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * java实现AES256加密解密
 */

public class CryptUtil {
    private final static Logger log = LogManager.getLogger(CryptUtil.class);
    public static final String password = "123456";
    public static String encrypt(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
            kgen.init(256, securerandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Security.addProvider(new BouncyCastleProvider());

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            return new String(Base64.encode(cryptograph));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cryptoStr) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom securerandom = new SecureRandom(tohash256Deal(password));
            kgen.init(256, securerandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] content = cipher.doFinal(Base64.decode(cryptoStr.getBytes("utf-8")));
            return new String(content);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static byte[] tohash256Deal(String datastr) {
        try {
            MessageDigest digester=MessageDigest.getInstance("SHA-256");
            digester.update(datastr.getBytes());
            byte[] hex=digester.digest();
            return hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void cryptEntity(Object entity){
        if(null == entity || "".equals(entity)){
            return;
        }
        Class<?> cls = entity.getClass();
        // 检测field是否存在
        try {
            // 获取实体字段集合
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                // 通过反射获取该属性对应的值
                f.setAccessible(true);
                // 获取字段值
                Object obj = f.get(entity);
                if(null == obj){
                    continue;
                }
                String value = f.get(entity).toString();
                Annotation[] arrayAno = f.getAnnotations();
                for (Annotation annotation : arrayAno) {
                    if(annotation.annotationType().equals(Encrypt.class)){
                        Method method = entity.getClass().getDeclaredMethod("set"+StringUtil.captureName(f.getName()),f.getType());
                        String encryptValue = CryptUtil.encrypt(value);
                        log.debug("encryptValue:"+encryptValue);
                        method.invoke(entity,encryptValue);
                    }
                    if(annotation.annotationType().equals(Decrypt.class)){
                        Method method = entity.getClass().getDeclaredMethod("get"+StringUtil.captureName(f.getName()));
                        String decryptValue = CryptUtil.decrypt(value);
                        log.debug("decryptValue:"+decryptValue);
                        if(null != decryptValue) {
                            method.invoke(entity, decryptValue);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void crypt(Object obj){
        if(null == obj){
            return;
        }
        if(obj instanceof List){
            List list = (List)obj;
            for(Object o : list){
                cryptEntity(o);
            }
        }


    }
}