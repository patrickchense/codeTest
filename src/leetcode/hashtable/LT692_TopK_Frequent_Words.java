package leetcode.hashtable;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-words/

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

@topK
@hashmap

@medium
@sovled


 */
public class LT692_TopK_Frequent_Words {

    //Time Complexity: O(N \log{k})O(Nlogk), where NN is the length of words. We count the frequency of each word in O(N)O(N) time, then we add NN words to the heap, each in O(\log {k})O(logk) time. Finally, we pop from the heap up to kk times. As k \leq Nk≤N, this is O(N \log{k})O(Nlogk) in total.
    // O(n) space
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String w= words[i];
            counts.put(w, counts.getOrDefault(w, 0) + 1);

        }
        PriorityQueue<String> queues = new PriorityQueue<>(k, (i, j) -> {if (counts.get(i) != counts.get(j)) {
            return counts.get(j) - counts.get(i);
        } else {
            return i.compareTo(j);
        }});

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            queues.add(entry.getKey());
        }

        List<String> res = new ArrayList<>(k);
        int i = 0;

        while(!queues.isEmpty() && i < k) {
            res.add(i++, queues.poll());
        }
        return res;
    }

    // by sort
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
    }
}
