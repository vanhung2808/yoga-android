package com.stdio.hue.yoga.shares.utils;

import android.util.Patterns;

/**
 * Created by TranHuuPhuc on 7/10/18.
 */
public class SHStringHelper {
    SHStringHelper() {
    }

    public static boolean nullOrEmpty(CharSequence input) {
        return input == null || input.toString().trim().length() == 0;
    }

    public static boolean notIsPassword(CharSequence input) {
        return input.toString().trim().length() < 6;
    }

    public static boolean notEqual(CharSequence one, CharSequence two) {
        return !one.toString().equals(two.toString());
    }

    public static boolean equal(CharSequence one, CharSequence two) {
        return one.toString().equals(two.toString());
    }

    public static boolean isEmail(CharSequence input) {
        return Patterns.EMAIL_ADDRESS.matcher(input).matches();
    }

    public static boolean numberPhone(String input) {
        return Patterns.PHONE.matcher(input).matches();
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
