package dailyproblem;

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

@twitter
@string
@trie
@answered
@review
这个hint应该就是要构建trie树的意思

对于Trie的解法还不是很熟

https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/

我这里用的不对吧？建了好几颗树？应该一颗？ 没结束

 */

import util.ArrayUtil;

import java.util.*;

public class Daily20181015 {

    public static void main(String[] args) {
        Daily20181015 d = new Daily20181015();
        ArrayUtil.printList(d.findPrefixStr(new String[]{"dog", "deer", "deal"}, "de"));
    }

    public List<String> findPrefixStr(String[] words, String prefix) {
        List<String> res = new ArrayList<>();
        /*Map<String, Trie> tries = new HashMap<>();
        for (String w : words) {
            Trie trie = new Trie();
            trie.insert(w);
            tries.put(w, trie);
        }

        for (String w : words) {
            if (tries.get(w).startsWith(prefix)) res.add(w);
        }*/
        Trie trie = new Trie();
        for (String w : words) trie.insert(w);

        res.addAll(trie.findAllPrefix(prefix));
        return res;
    }

    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                int index = c-'a';
                if(p.arr[index]==null){
                    TrieNode temp = new TrieNode();
                    p.arr[index]=temp;
                    p = temp;
                }else{
                    p=p.arr[index];
                }
            }
            p.isEnd=true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = searchNode(word);
            if(p==null){
                return false;
            }else{
                if(p.isEnd)
                    return true;
            }

            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = searchNode(prefix);
            if(p==null){
                return false;
            }else{
                return true;
            }
        }

        public TrieNode searchNode(String s){
            TrieNode p = root;
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                int index = c-'a';
                if(p.arr[index]!=null){
                    p = p.arr[index];
                }else{
                    return null;
                }
            }

            if(p==root)
                return null;

            return p;
        }

        public Collection<? extends String> findAllPrefix(String prefix) {
            TrieNode p = root;
            List<String> res = new ArrayList<>();
            TrieNode[] lefts = null;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c -'a';
                if (p.arr[index] == null) return res;
                else {
                    p = p.arr[index];
                }
                if (i == prefix.length() - 1) lefts = p.arr;
            }

            // combine the left

            return res;
        }


    }

}
