package daily2019;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a word W and a string S, find all starting indices in S which are anagrams of W.

For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

@Google
@string
@solved
@needOptimize

返回s中有W的坐标，可以乱序
我用map才能判断是否一致乱序，应该有更好的方法吧！！！！怎么处理？？
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/262140/Sliding-Window-Java-Solution 这个用了数组占位的方式来代替map

@slidewindow
@review

slidewindow的问题，还可以搜索几个问题

 */
public class D20190123 {

    public static void main(String[] args) {
        ArrayUtil.printList(findWordsInString("abxaba", "ab"));
    }

    public static List<Integer> findWordsInString(String str, String w) {
        List<Integer> res= new ArrayList<>();
        Map<Character, Integer> words = new HashMap<>();
        for (Character c : w.toCharArray()) {
            if (words.containsKey(c)) {
                words.put(c, words.get(c) + 1);
            } else {
                words.put(c, 1);
            }
        }
        boolean previous = false;
        // 关键的逻辑在于1. 这个i的边界，有时候忽略了最后的字母
        for (int i = 0; i < str.length() - w.length() + 1; i++) {
            if (words.containsKey(str.charAt(i))) {
               if (previous) {
                   //only need to compare one character
                   if (str.charAt(i-1) == str.charAt(i + w.length()-1)) {
                       res.add(i);
                       continue;
                   } else {
                       previous = false;
                       continue;
                   }
               }
               if (isMatch(str.toCharArray(), i, i+w.length(), words)) {
                   res.add(i);
                   previous = true;
               }
            }
        }
        return res;
    }

    public static boolean isMatch(char[] s, int i, int j, Map<Character, Integer> words) {
        Map<Character, Integer> cur = new HashMap<>();
        for (; i < j; i++) {
            if (!words.containsKey(s[i])) return false;
            if (cur.containsKey(s[i])) {
                cur.put(s[i], cur.get(s[i]) + 1);
            } else {
                cur.put(s[i], 1);
            }
        }
        for (Character c : words.keySet()) {
            if (!cur.get(c).equals(words.get(c))) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
