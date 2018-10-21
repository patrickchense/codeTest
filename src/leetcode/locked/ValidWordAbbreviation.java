package leetcode.locked;

import java.net.Inet4Address;

/*
leetcode 408
Valid Word Abbreviation

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:

Given s = "internationalization", abbr = "i12iz4n":

Return true.


Example 2:

Given s = "apple", abbr = "a2e":

Return false.

@solved

 */
public class ValidWordAbbreviation {

    /*
    两指针，分别遍历两个string
    需要注意的是 index 的变化，还有特殊情况比如数字结尾
    O(n), O(1)
     */
    public static boolean validateWordAbbr(String word, String abbr) {
        int i = 0;
        int j = 0;
        boolean startCount = false;
        int c = 0;
        while(i < word.length() && j < abbr.length()) {
            if (!startCount && word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (!startCount && !(abbr.charAt(j) <= '9' && abbr.charAt(j) > '0')) break;
                if (!startCount && abbr.charAt(j) <= '9' && abbr.charAt(j) > '0') {
                    startCount = true;
                    c = Character.digit(abbr.charAt(j), 10);
                    j++;
                }
                else if (startCount && abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0'){
                    c = c * 10 + Character.digit(abbr.charAt(j), 10);
                    j++;
                }
                else if (startCount && !(abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0')) {
                    startCount = false;
                    i += c;
                }
            }
        }
        if (startCount) {
            // not finish
            if (i + c == word.length() && j == abbr.length()) return true;
        }
        if (i == word.length() && j == abbr.length()) return true;
        return false;
    }

    /*
    这个网上的例子，利用了双循环，而不是我这种单循环
    更清晰的感觉
     */
    Boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, m = word.length(), n = abbr.length();
        while (i < m && j < n) {
            if (abbr.charAt(i) >= '0' && abbr.charAt(j) <= '9') {
                if (abbr.charAt(j) == '0') return false;
                int val = 0;
                while (j < n && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    val = val * 10 + abbr.charAt(j++) - '0';
                }
                i += val;
            } else {
                if (word.charAt(i++) != abbr.charAt(j++)) return false;
            }
        }
        return i == m && j == n;
    }

    public static void main(String[] args) {
        System.out.println(validateWordAbbr("internationalization", "i12iz4n"));
        System.out.println(validateWordAbbr("internationalization", "i12iza4"));
        System.out.println(validateWordAbbr("apple", "a2e"));
    }
}
