package com.example.apuser.mydraggablepanel.util;

/**
 * Created by apuser on 3/30/15.
 */
public class StringUtils {

    private static final String EMPTY_STRING = "";

    private StringUtils() {
        //Empty
    }

    public static boolean isNullOrEmpty(final String string) {
        return string == null || EMPTY_STRING.equals(string);
    }
}
