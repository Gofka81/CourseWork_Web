package com.polyteh.taxi.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Class encrypts any password using Md5Hex.
 *
 * @author L. Antonyk
 */
public class PasswordEncoder {

    private PasswordEncoder() {
    }

    public static String encode(String password) {
        return DigestUtils.md5Hex(password);
    }
}
