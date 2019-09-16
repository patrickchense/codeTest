package uber;

import java.util.*;

/*
Given a list of words, find all the Palindrome combinations by concatenating 2 strings.

Ex: <cat, rat, mat, tab, bat, car, race>
race + car -> Palindrome
tab + bat -> Palindrome

https://leetcode.com/problems/palindrome-pairs

@phone
@hard
@tire
@review

 */
public class PalindromePairs {

	public static void main(String[] args) {
		System.out.println(palindrome(Arrays.asList("cat", "rat", "mat", "tab", "bat", "car", "race")));
		System.out.println(palindrome(Arrays.asList("abcd","dcba","lls","s","sssll")));
	}

	public static List<String> palindrome(List<String> words) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.size(); i++) {
			map.put(new StringBuilder(words.get(i)).reverse().toString(), i);
		}

		for(int i = 0; i < words.size(); i++) {
			if(map.containsKey(words.get(i)) && map.get(words.get(i)) != i) {
				res.add(words.get(i) + words.get(map.get(words.get(i))));
			}
			for(int j = 0; j < words.get(i).length(); j++) {
				if(isPalindrome(words.get(i).substring(j)) && map.containsKey(words.get(i).substring(0, j))) {
					res.add(words.get(i) + words.get(map.get(words.get(i).substring(0, j))));
				}
			}
			for(int j = words.get(i).length(); j > 0; j--) {
				if(isPalindrome(words.get(i).substring(0, j)) && map.containsKey(words.get(i).substring(j))) {
					res.add(words.get(i) + words.get(map.get(words.get(i).substring(j))));
				}
			}
		}
		return res;
	}

	private static boolean isPalindrome(String w) {
		int st = 0, ed = w.length() - 1;
		while(st < ed) {
			if(w.charAt(st++) != w.charAt(ed--)) return false;
		}
		return true;
	}

	// Tire, fast
	private static class TrieNode {
		TrieNode[] kids;
		Set<Integer> palindromeIndices;
		int index;

		public TrieNode() {
			kids = new TrieNode[26];
			palindromeIndices = new HashSet<>();
			index = -1;
		}
	}

	private TrieNode root;

	// n: number of words
	// k: length of longest word
	// l: numbers of distinct characters

	// Time: O(n*k^2)
	// Space: O(n*k*l)
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if (words == null || words.length == 0) {
			return res;
		}

		root = new TrieNode();

		for (int i = 0; i < words.length; i++) {
			insert(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			findPalindromePairs(res, words[i], i);
		}

		return res;
	}

	// k: word length of k
	// n: no. of words
	// Time: O(k^2 + n)
	private void findPalindromePairs(List<List<Integer>> res, String word, int index) {
		TrieNode parent = root;
		for (int i = 0; i < word.length(); i++) {
			if (parent.index >= 0 && isPalindrome(word, i, word.length() - 1)) {
				res.add(Arrays.asList(index, parent.index));
			}

			int idx = word.charAt(i) - 'a';

			if (parent.kids[idx] == null) {
				return;
			}

			parent = parent.kids[idx];
		}

		// add pair of current index and words with match current word and the latter part is palindrome
		for (int idx : parent.palindromeIndices) {
			res.add(Arrays.asList(index, idx));
		}

		// pair of word with matching reverse
		if (parent.index >= 0 && index != parent.index) {
			res.add(Arrays.asList(index, parent.index));
		}
	}

	// k: word length of k
	// Time: O(k^2)
	private void insert(String word, int index) {
		TrieNode parent = root;

		for (int i = word.length() - 1; i >= 0; i--) {
			// if prefix (0, i) is palindrome, add to list
			if (isPalindrome(word, 0, i)) {
				parent.palindromeIndices.add(index);
			}

			int idx = word.charAt(i) - 'a';

			if (parent.kids[idx] == null) {
				parent.kids[idx] = new TrieNode();
			}

			parent = parent.kids[idx];
		}

		parent.index = index;
	}

	// k: length of word
	// Time: O(k)
	private static boolean isPalindrome(String word, int from, int to) {
		if (from > to) return false;

		while (from < to) {
			if (word.charAt(from) != word.charAt(to)) {
				return false;
			}
			from++;
			to--;
		}

		return true;
	}
}
