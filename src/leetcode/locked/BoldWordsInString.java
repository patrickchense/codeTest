package leetcode.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
leetcode 758
http://www.cnblogs.com/grandyang/p/8531642.html

Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:

words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.

@string contact

 */
public class BoldWordsInString {

    /*
    O(n) space, O(n * keys) time
     */
    public String boldWords(String s, String[] keys) {
        int n = s.length();
        String res = "";
        List<Boolean> boldEnable = new ArrayList<>(n);
        Collections.fill(boldEnable, Boolean.FALSE);
        for (String word : keys) {
            int len = word.length();
            for (int i = 0; i <= n - len; ++i) {
                if (s.charAt(i) == word.charAt(0) && s.substring(i, len).equals(word)) {
                    for (int j = i; j < i + len; ++j) boldEnable.add(j, true);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (boldEnable.get(i)) {
                if (i == 0 || !boldEnable.get(i - 1)) res += "<b>";
                res += s.charAt(i);
                if (i == n - 1 || !boldEnable.get(i + 1)) res += "</b>";
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
