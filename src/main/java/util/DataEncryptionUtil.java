package util;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64编码
 *
 * @author wangYabin
 **/
public class DataEncryptionUtil {

    /**
     * 给予Base64的密码编码
     **/
    public static String encodeBase64(String password) {
        if (password == null) {
            return null;
        }
        password = new String(Base64.encodeBase64(password.getBytes()));
        return password;
    }

    /**
     * 基于Base64的密码解密
     **/
    public static String decodeBase64(String pass) {

        byte[] bytes = Base64.decodeBase64(pass);


        return new String();
    }
}
