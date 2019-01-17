package dailyproblem;

/*
Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

@facebook
@solved
 */
public class Daily20181229 {

    public static void main(String[] args) {
        System.out.println(DotStarMatch("ra.","ray"));
        System.out.println(DotStarMatch("ra.","ramond"));
        System.out.println(DotStarMatch(".*at","chat"));
        System.out.println(DotStarMatch(".*at","chaatt"));
        System.out.println(DotStarMatch(".*at","chats"));
    }

    public static boolean DotStarMatch(String regx, String s) {
        int i = 0;
        int j = 0;
        while (i < regx.length() && j < s.length()) {
            char c = regx.charAt(i);
            char d = s.charAt(j);
            if (c == '.') {
                i++;
                j++;
            } else if (c == '*') {
                if (regx.length() - i == s.length() - j) {
                    i++;
                    j++;
                }
                else {
                    j++;
                }
            }
            else {
                if (c != d) return false;
                i++;
                j++;
            }
        }
        return i == regx.length() && j == s.length();
    }
}
