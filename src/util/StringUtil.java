package util;

import java.util.Arrays;

public class StringUtil {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());
    }
}
