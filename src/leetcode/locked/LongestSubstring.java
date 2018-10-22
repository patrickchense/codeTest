package leetcode.locked;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 159
Longest Substring with At Most Two Distinct Characters

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
For example, Given s = “eceba”,
T is "ece" which its length is 3.

http://buttercola.blogspot.com/2015/08/leetcode-longest-substring-with-at-most.html
related
http://buttercola.blogspot.com/2014/08/leetcode-longest-substring-without.html

@map

 */
public class LongestSubstring {

    // O(n), O(k) k == distinct numbers
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 3) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int j = 0;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            if (!map.containsKey(element)) {
                counter++;
                map.put(element, 1);

                while (j < i && counter > 2) {
                    if (map.get(s.charAt(j)) == 1) {
                        map.remove(s.charAt(j));
                    } else {
                        int tmp = map.get(s.charAt(j)) - 1;
                        map.put(s.charAt(j), tmp);
                    }

                    if (!map.containsKey(s.charAt(j))) {
                        counter--;
                    }
                    j++;
                }
            } else {
                int tmp = map.get(s.charAt(i));
                map.put(s.charAt(i), tmp + 1);
            }

            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;

    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ecebaaaaa"));
    }

    //Longest Substring Without Repeating Characters
    /*
    Given a string, find the length of the longest substring without repeating characters.
     For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
     For "bbbbb" the longest substring is "b", with the length of 1.
     */
    /*
    The question asks for finding the longest substring without repeating characters, and return its length. So the problem has two requirements:

1. Find a substring without repeating characters, and keep its length
2. Return the longest length

We can give several examples from empty string to common cases:
a. For empty string, its substring is empty as well, so return the length 0
b. For string length equals to 1, the longest substring is itself, return 1;
c. For string "aab", its longest substring is "ab", return 2;
d. For string "abcabcbb", the longest substring is "abc", return 3.

     */

    public int lengthOfLongestSubstring(String s) {
        // if the string is empty or has only one character
        if (s.length() < 2) return s.length();

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int j = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), i);
            } else {
                maxLen = Math.max(maxLen, i - j);
                for (int k = j; k < i; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        j = k + 1;
                        break;
                    }
                }
            }
        }
        return Math.max(maxLen, s.length() - j);
    }
}
