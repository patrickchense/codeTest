package ciphers;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAEncryption {

    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public static void generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            String publicKeyStr = getKeyString(publicKey);
            String privateKeyStr = getKeyString(privateKey);

            System.out.println("publicKeyStr :" + publicKeyStr);
            System.out.println("privateKeyStr :" + privateKeyStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    public static String getKeyString(Key key) {
        byte[] keyBytes = key.getEncoded();
        return Base64.encode(keyBytes);
    }


    public static String encrypt(String publicKey, String content) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
            byte[] encryptBytes = cipher.doFinal(content.getBytes());
            return Base64.encode(encryptBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String privateKey, String content) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(privateKey));
            byte[] decryptBytes = cipher.doFinal(Base64.decode(content));
            return new String(decryptBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

//        generateKeyPair();

        final String publicKey = "使用generateKeyPair生成";
        final String privateKey = "使用generateKeyPair生成";

        String content = "九点下班";
        String encryptStr = encrypt(publicKey, content);
        System.out.println("加密：" + encryptStr);
        String decryptStr = decrypt(privateKey, encryptStr);
        System.out.println("解密：" + decryptStr);
    }
}
