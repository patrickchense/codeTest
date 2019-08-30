package leetcode.dp;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 *
 * @dp
 * @string
 * @array
 * @optimize
 * @recursive
 */
public class LT139_wordbreak {

	/*
		one way is O(n^2) and map O(n)

		using map to store records and loop index one by one

		very slow in results
	 */
	public boolean wordBreak(String s, List<String> wordDict) {

		Map<String, Boolean> seen = new HashMap<>();
		return wordBreak1(s, wordDict, seen);

	}


	public boolean wordBreak1(String s, List<String> wordDict, Map<String, Boolean> seen) {

		String temp = "";
		int start = 0;
		int len = s.length();

		if (s.isEmpty())
			return true;
		if (seen.containsKey(s))
			return seen.get(s);

		ArrayList<String> a = new ArrayList<String>(wordDict);

		Collections.sort(a, Collections.reverseOrder());

		// System.out.println(s);
		// System.out.println(a);

		for (int i = 0; i <= s.length(); i++) {
			temp = s.substring(start, i);
			for (int j = 0; j < wordDict.size(); j++) {
				if (temp.equals(a.get(j)) && wordBreak1(s.substring(i, len), wordDict, seen)) {

					return true;
				}
			}

			// System.out.println(temp);
		}

		seen.put(s, false);

		// System.out.println(temp);


		return false;

	}

	/*
	optimize, loop from dics, and using O(n) to record, very efficient because dics size is smaller
	dp is the table,
	 */
	private int[] table;
	public boolean wordBreak2(String word, List<String> wordDict) {
		table = new int[word.length()+1];
		Arrays.fill(table,-1); // Three values required:
		// -1- word break not invoked from this index,
		// 0 - word break from that index not possible
		// 1 - word break possible from that index
		table[word.length()] = 1;//Word break possible from last index of string i.e. Empty String
		return wordBreakRecursive(word,wordDict,0);
	}
	private boolean wordBreakRecursive(String word, List<String> wordDict,int index) {
		if(table[index]>=0){ // word break was invoked before. Use the store value
			return table[index] == 0? false:true;
		}
		for(String dictWord:wordDict){ //For each word check if the string startwith the word.
			if(word.startsWith(dictWord) ){
				boolean wordBreakSubstring= wordBreakRecursive(word.substring(dictWord.length()),wordDict,index+dictWord.length()); //if starts, check if remaining word could be broken
				table[index+dictWord.length()] = wordBreakSubstring?1:0; // update the dp table.
				if(wordBreakSubstring) //if break successful, return
					return true;
			}
		}
		return false;
	}
}
