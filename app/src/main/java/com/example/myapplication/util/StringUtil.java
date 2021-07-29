package com.example.myapplication.util;

/**
 * created by cxm1995
 * on 2021/4/20 16:19
 */
public class StringUtil {
    public static boolean isNotEmpty(String s) {
        if (s == null || s.length() == 0) return false;
        return true;
    }
}
