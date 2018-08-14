package com.eshop.serviceweb.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import com.sun.jersey.core.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * java实现AES256加密解密
 */

public class CryptoUtil {

    public static byte[] encrypt(String content, String password) {
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
            return Base64.encode(cryptograph);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(byte[] cryptograph, String password) {
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
            byte[] content = cipher.doFinal(Base64.decode(cryptograph));
            return new String(content);
        } catch (Exception e) {
            e.printStackTrace();
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

    public static void main(String[] args) {

        String content = "你好！";
        String password = "www";
        System.out.println("明文：" + content);
        System.out.println("key：" + password);
        byte[] encryptResult = CryptoUtil.encrypt(content, password);
        System.out.println("密文：" + CryptoUtil.parseByte2HexStr(encryptResult));
        String decryptResult = CryptoUtil.decrypt(encryptResult, password);
        System.out.println("解密：" + decryptResult);
    }
}