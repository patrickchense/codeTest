package util;

import java.util.regex.Pattern;

/*
most common use java regex
https://www.cnblogs.com/zxin/archive/2013/01/26/2877765.html
https://www.w3cschool.cn/regexp/m2ez1pqk.html
 */
public class RegexUtils {

    public static boolean isDouble(String s) {
        if (s.startsWith("-") || s.startsWith("+")) {
            s = s.substring(1);
        }
        if (s.length() <= 1) {
            return false;
        }
        return s.matches("^([0-9]*)?+\\.([0-9]*)$");
    }

    public static boolean isInteger(String s) {
        return s.matches("^(-|\\+)?([0-9]{1,})$");
    }

    /*
        one regex to represent all
     */
    public static boolean isNumber2(String s) {
        return s.matches("^ *[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))(e[+-]?[0-9]+)? *$");
    }


    public static boolean isEmail(String s) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\\\\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return p.matcher(s).find();
    }

    public static boolean isIp(String s) {
        Pattern p = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\\\d|[01]?\\\\d?\\\\d)\\\\.){3}(?:25[0-5]|2[0-4]\\\\d|[01]?\\\\d?\\\\d))");
        return p.matcher(s).find();
    }


}
