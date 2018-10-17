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
        Map<Character, Integer> chars = new HashMap<>();
        int start = 0;
        int end = k-1;
        for (int i = 0 ; i < s.toCharArray().length; i++)  {

        }
        return null;
    }
}
