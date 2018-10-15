package GoldmanSachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a span of text, find the shortest distance between certain two words.

leetcode all locked

WorkSearch I
https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.4.html

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.

Note

You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Word SearchII
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,

Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.


Word Search III
word1 and word2 can be equal

 */
public class ShortestDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length, idx1 = -1, idx2 = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) idx1 = i;
            else if (words[i].equals(word2)) idx2 = i;
            if (idx1 != -1 && idx2 != -1)
                dist = Math.min(dist, Math.abs(idx1 - idx2));
        }
        return dist;
    }

    // use only one idx
    int shortestDistanceUseOnlyOneIdx(String[] words, String word1, String word2) {
        int idx = -1, dist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (idx != -1 && !words[idx].equals(words[i])) {
                    dist = Math.min(dist, i - idx);
                }
                idx = i;
            }
        }
        return dist;
    }

    // word1 and word2 can be equal
    int shortestDistance3(String[] words, String word1, String word2) {
        int n = words.length;
        int p1 = -1, p2 = -1, dist = Integer.MAX_VALUE;
        for(int i=0; i<n; ++i){
            if(word1.equals(word2)){
                if(words[i].equals(word1)){
                    if(p1>p2) p2 = i;
                    else p1 = i;
                }
            }else{
                if(words[i].equals(word1)) p1 = i;
                if(words[i].equals(word2)) p2 = i;
            }
            if(p1>=0 && p2>=0)
                dist = Math.min(dist, Math.abs(p1-p2));
        }
        return dist;
    }

    // word search II
    /*
    use map to store the word - index (duplicate word works)
     */
    public class WordDistance {
        HashMap<String, List<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<>();
            for(int i=0; i<words.length; i++){
                if(map.containsKey(words[i])){
                    map.get(words[i]).add(i);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(words[i], list);
                }
            }
        }

        public int shortest(String word1, String word2) {

            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);

            int result = Integer.MAX_VALUE;
            for(int i1: l1){
                for(int i2: l2){
                    result = Math.min(result, Math.abs(i1-i2));
                }
            }
            return result;
        }

        public int shortestImprove(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);

            int result = Integer.MAX_VALUE;
            int i=0;
            int j=0;
            while(i<l1.size() && j<l2.size()){
                result = Math.min(result, Math.abs(l1.get(i)-l2.get(j)));
                if(l1.get(i)<l2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
            return result;
        }
    }
}
