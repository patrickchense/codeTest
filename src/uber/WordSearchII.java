package uber;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/word-search-ii/

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.

@onsite
@hard

@dfs

@solved
@optimized


 */
public class WordSearchII {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("oath");
		words.add("eat");
		words.add("pea");
		words.add("rain");
//		wordSearchII(new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}}, words);

		/*
		* [["a","b","c"],["a","e","d"],["a","f","g"]]
["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]
		* */

		words.clear();
//		words.add("abcdefg");
//		words.add("gfedcbaaa");
		words.add("eaabcdgfa");
//		words.add("befa");
//		words.add("ade");
//		words.add("dgc");

		System.out.println(wordSearchII(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, words));
	}

	public static List<String> wordSearchII(char[][] board, List<String> words) {
		List<String> ws = new ArrayList<>();
		Set<String> result = new HashSet<>();
		for (String w : words) ws.add(w);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boolean[][] visted = new boolean[board.length][board[0].length];
				dfs(board, visted, ws, 0, i, j, result);
			}
		}
		return new ArrayList(result);
	}

	// O(n^2 * k * len(words) ) k is len of word
	public static void dfs(char[][] cs, boolean[][] visited, List<String> matches, int curPos, int m, int n, Set<String> result) {
		if (m < 0 || n < 0 || m >= cs.length || n >= cs[0].length) return;
		if (visited[m][n]) return;
		List<String> rest = matches.stream().filter(w -> w.charAt(curPos) == cs[m][n]).collect(Collectors.toList());
		if (rest.isEmpty()) return;
		Iterator<String> ite = rest.iterator();
		while (ite.hasNext()) {
			String w = ite.next();
			if (w.length() == curPos + 1) {
				result.add(w);
				ite.remove();
			}
		}
		if (rest.isEmpty()) return;
		visited[m][n] = true;
		dfs(cs, visited, rest, curPos + 1, m + 1, n, result);
		dfs(cs, visited, rest, curPos + 1, m - 1, n, result);
		dfs(cs, visited, rest, curPos + 1, m, n + 1, result);
		dfs(cs, visited, rest, curPos + 1, m, n - 1, result);
		visited[m][n] = false;
	}

	//optimize? dfs is very slow
	// using tire to handle word match
	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		int m = board.length;
		if (m == 0) return ans;
		int n = board[0].length;
		Trie root = createTrie(words);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, root, new StringBuilder(), i, j, ans);
			}
		}
		return ans;
	}

	private void dfs(char[][] board, Trie node, StringBuilder sb, int i, int j, List<String> ans) {
		int m = board.length, n = board[0].length;
		char ch = board[i][j];
		if (ch == '#' || node.next[ch - 'a'] == null) return;
		sb.append(ch);
		board[i][j] = '#';

		node = node.next[ch - 'a'];
		if (node.word != null) {
			ans.add(sb.toString());
			node.word = null;
		}
		if (i + 1 < m) dfs(board, node, sb, i + 1, j, ans);
		if (j + 1 < n) dfs(board, node, sb, i, j + 1, ans);
		if (i - 1 >= 0) dfs(board, node, sb, i - 1, j, ans);
		if (j - 1 >= 0) dfs(board, node, sb, i, j - 1, ans);

		sb.deleteCharAt(sb.length() - 1);
		board[i][j] = ch;
	}

	// create Tire common  创建Tire树通用方法
	public Trie createTrie(String[] words) {
		Trie root = new Trie();
		for (String word : words) {
			Trie node = root;
			for (char c : word.toCharArray()) {
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new Trie();
				}
				node = node.next[c - 'a'];
			}
			node.word = word;
		}
		return root;
	}

	class Trie {
		Trie[] next = new Trie[26];
		String word;
	}

}
