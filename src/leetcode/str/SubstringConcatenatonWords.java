package leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
leetcode 30
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []


 */
public class SubstringConcatenatonWords {


    /*brute force always working
        use Map to keep the words, add delete when matches

        O(n * k), n = S.length, k = words.length,  O(n^k) space

        optimize with map clear/putAll, use O(k) space

    */
    public List<Integer> findSubstring(String S, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<>(); // map for L
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        Map<String, Integer> copy = new HashMap<>(map);
        for (int i = 0; i <= S.length() - len * words.length; i++) {
            for (int j = 0; j < words.length; j++) { // checkc if match
                String str = S.substring(i + j * len, i + j * len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        copy.putAll(map);
                        break;
                    }
                } else break; // not in L
            }
            copy.clear();
            copy.putAll(map);
        }
        return res;
    }
}
