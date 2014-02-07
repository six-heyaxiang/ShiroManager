package com.shiromanager.Utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/18/14
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class EncryptUtils {
    public static final String encryptMD5(String source) {
        if (source == null) {
            source = "";
        }
        Md5Hash md5 = new Md5Hash(source);
        return md5.toString();
    }
}
