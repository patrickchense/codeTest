package leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
leetcode 890
https://leetcode.com/problems/find-and-replace-pattern/description/

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern.

You may return the answer in any order.



Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.


Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20


 */
public class FindReplacePattern {

    /*
    use two Map
        O(n * k) time, O(k) space
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Character> matches = new HashMap<>();
        Map<Character, Character> patternMatches = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String w : words) {
            if (w.length() != pattern.length()) continue;
            boolean isMatch = true;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                char d = pattern.charAt(i);
                if (matches.containsKey(c)) {
                    if (matches.get(c) != d) {
                        isMatch = false;
                        break;
                    }
                }
                if (patternMatches.containsKey(d)){
                    if (patternMatches.get(d) != c) {
                        isMatch = false;
                        break;
                    }
                }
                matches.put(c, d);
                patternMatches.put(d, c);
            }
            matches.clear();
            patternMatches.clear();
            if (isMatch) res.add(w);
        }
        return res;
    }
}
