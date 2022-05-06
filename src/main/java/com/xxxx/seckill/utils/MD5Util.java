package com.xxxx.seckill.utils;

import lombok.val;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md2Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass){
        // 12+密码+c3
        String str =  salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt){
        String str = salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }


    public static String inputPassToDBPass(String inputPass, String salt){
        String formPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(formPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        //82a693d3173db016d77c59a41d302b20
        System.out.println(inputPassToFromPass("123456"));
        //a0de3e469073b293e3187df16fe5a6a2
        System.out.println(formPassToDBPass("82a693d3173db016d77c59a41d302b20","1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));

    }

}
