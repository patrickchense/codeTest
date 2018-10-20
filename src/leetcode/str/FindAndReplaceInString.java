package leetcode.str;

/*
leetcode 833
https://leetcode.com/problems/find-and-replace-in-string/description/

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
"ec" doesn't starts at index 2 in the original S, so we do nothing.

solution:
same size array, if null no replace
StringBuilder replace func(start, len, new_str);
 */
public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String[] src_index = new String[S.length()];
        String[] tar_index = new String[S.length()];

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            String sub = S.substring(index);
            if (sub.startsWith(sources[i])) {
                src_index[index] = sources[i];
                tar_index[index] = targets[i];
            }
        }

        StringBuilder sb = new StringBuilder(S);

        for (int i = src_index.length - 1; i >= 0; i--) {
            if (src_index[i] != null) {
                int key_size = src_index[i].length();
                sb.replace(i, i + key_size, tar_index[i]);
            }
        }
        return sb.toString();
    }
}
