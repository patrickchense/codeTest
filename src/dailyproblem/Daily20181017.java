package dailyproblem;

import java.util.HashMap;
import java.util.Map;

/*

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

@amazon

thinking,

original:
https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/

related
@re-read
https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/


 */
public class Daily20181017 {

    public String longestSubArrayDistance(String s, int k) {
        if (k >= s.length()) return s;
        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> charPos = new HashMap<>();
        int start = 0;
        int end = 0;
        int i = 0;
        int count = 0;
        while (true) {
            if (count == k) {
                end = i;
                break;
            }
            if (charPos.containsKey(s.charAt(i))) {
                chars.put(s.charAt(i), i - charPos.get(s.charAt(i)));
            } else {
                charPos.put(s.charAt(i), i);
                chars.put(s.charAt(i), -1);
                count++;
            }
            i++;
        }
        return null;
    }

    // O(n) space O(n^2) time
    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > 2) {
                max = Math.max(max, i - start);

                while (map.size() > 2) {
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        map.remove(t);
                    }
                    start++;
                }
            }
        }

        max = Math.max(max, s.length() - start);

        return max;
    }

    // O(n) time
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;

        if (s.length() < k)
            return s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen = k;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);

                while (map.size() > k) {

                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }

                    left++;
                }
            }

        }

        maxLen = Math.max(maxLen, s.length() - left);

        return maxLen;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstringKDistinct("abcba", 2));
    }
}
