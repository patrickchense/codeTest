package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
leetcode 79 wordSearch I
https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

@type: 2D数组类型的backtracking题型，是否能组合成一个target（或者sum）或者所有可能选择等
@backtracking

@related
word Search II
https://leetcode.com/problems/word-search-ii/description/

 */
public class WordSearch {

    boolean flag = false;

    public boolean wordSearchI(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    help(board, i, j, sb, word);
                    if (flag) return true;
                }
            }
        }
        return false;
    }

    void help(char[][] board, int i, int j, StringBuilder sb, String word) {
        if (sb.length() == word.length()) {
            if (sb.toString().equals(word)) {
                flag = true;
            }
            return;
        }
        if (i < 0 || j < 0 || flag || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '-' || board[i][j] != word.charAt(sb.length()))
            return;
        sb.append(board[i][j]);
        board[i][j] = '-';
        help(board, i + 1, j, sb, word);
        help(board, i - 1, j, sb, word);
        help(board, i, j + 1, sb, word);
        help(board, i, j - 1, sb, word);
        board[i][j] = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    /*
    Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.

@backtracking
@tire
@need to understand TODO
     */

    private class TrieNode{
        TrieNode[] arr;
        String word=null;
        public TrieNode(){
            arr=new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<String>();
        TrieNode t=buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,t,res);
            }
        }
        return res;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(String w: words){
            TrieNode p=root;
            for(char c:w.toCharArray()){
                int idx=c-'a';
                if(p.arr[idx]==null){
                    p.arr[idx]=new TrieNode();
                }
                p=p.arr[idx];
            }
            //System.out.println(p.word);
            p.word=w;
        }
        return root;
    }
    private void dfs(char[][] board,int i,int j,TrieNode p,List<String> res){
        char c=board[i][j];
        if(c=='#'||p.arr[c-'a']==null) return;
        p=p.arr[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word=null;
        }
        board[i][j]='#';
        if(i>0) dfs(board,i-1,j,p,res);
        if(j>0) dfs(board,i,j-1,p,res);
        if(i<board.length-1) dfs(board,i+1,j,p,res);
        if(j<board[0].length-1) dfs(board,i,j+1,p,res);
        board[i][j]=c;
    }
}
