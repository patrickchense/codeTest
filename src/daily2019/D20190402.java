package daily2019;

import util.ArrayUtil;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/*
Given a string, split it into as few strings as possible such that each string is a palindrome.

For example, given the input string racecarannakayak, return ["racecar", "anna", "kayak"].

Given the input string abc, return ["a", "b", "c"].

@Google
@hard
@string
@palindrome
@solved
@15min

split string into 最长子序列(palindrome)

比较笨的方式, 暴力
1. 从0开始，倒序找到下一个，相同字母，判断是否palindrome，是，分割，不是继续直到i,j相遇
2. 偏离下个字母，从子序列的长度+1开始
 */
public class D20190402 {

    public static void main(String[] args) {
        String str = "racecarannakayak";
        ArrayUtil.printList(substringPalindrome(str));
         str = "abc";
        ArrayUtil.printList(substringPalindrome(str));
    }

    public static List<String> substringPalindrome(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            char a = str.charAt(i);
            boolean isMatch = false;
            for (int j = str.length()-1; j > i; j--) {
                if (str.charAt(j) == a && StringUtil.isPalindrome(str.substring(i, j+1))) {
                    res.add(str.substring(i, j+1));
                    i = j+1;
                    isMatch = true;
                    break;
                }
            }
            // not match
            if (!isMatch) {
                res.add(String.valueOf(a));
                i++;
            }
        }
        return res;
    }
}
