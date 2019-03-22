package daily2019;

import util.ArrayUtil;

import java.util.*;

/**
 *
 Given a list of words, return the shortest unique prefix of each word. For example, given the list:
 dog
 cat
 apple
 apricot
 fish
 Return the list:

 d
 c
 app
 apr
 f

 @Square
 @solved
 @review
 使用Tire来获取比较prefix一系列问题
 三数组Trie（Tripple-Array Trie）结构包括三个数组：base,next和check.
 二数组Trie（Double-Array Trie）包含base和check两个数组。base数组的每个元素表示一个Trie节点，即一个状态；check数组表示某个状态的前驱状态。
 解释： https://blog.csdn.net/lisonglisonglisong/article/details/45584721
 插入和查询的效率很高，都为O(m)，其中 m 是待插入/查询的字符串的长度
 检索中:
 struct trie_node
 {
 bool isKey;   // 标记该节点是否代表一个关键字
 trie_node *children[26]; // 各个子节点
 };
 词频统计:
 struct trie_node
 {
 int count;   // 记录该节点代表的单词的个数
 trie_node *children[26]; // 各个子节点
 };
 为了实现词频统计，我们修改了节点结构，用一个整型变量count来计数。对每一个关键字执行插入操作，若已存在，计数加1，若不存在，插入后count置1
 字符串排序
 Trie树可以对大量字符串按字典序进行排序，思路也很简单：遍历一次所有关键字，将它们全部插入trie树，树的每个结点的所有儿子很显然地按照字母表排序，然后先序遍历输出Trie树中所有关键字即可。
 前缀匹配
 例如：找出一个字符串集合中所有以ab开头的字符串。我们只需要用所有字符串构造一个trie树，然后输出以a->b->开头的路径上的关键字即可

 https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/ 使用Tire
 https://www.geeksforgeeks.org/longest-common-prefix-using-trie/
 https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 https://www.geeksforgeeks.org/word-break-problem-trie-solution/
 https://www.geeksforgeeks.org/pattern-searching-using-trie-suffixes/
 https://www.geeksforgeeks.org/trie-insert-and-search/

 */
public class D20190315 {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "cat", "apple", "apricot", "fish"};
        ArrayUtil.printList(shortestUniquePrefix(strs));
    }

    // O(n) space O(n*k) time k=max_len(pre)
    public static List<String> shortestUniquePrefix(String[] strs) {
        Map<String, String> map = new HashMap<>();
        String[] prefixes = new String[strs.length];
        for (int j = 0; j < strs.length; j++) {
            String s = strs[j];
            for (int i = 1; i < s.length() -1; i++) {
                String p = s.substring(0, i);
                if (!map.containsKey(p)) {
                    map.put(p, s + "_" + j);
                    prefixes[j] = p;
                    break;
                } else {
                    String old = map.get(p);
                    map.remove(p);
                    if (i + 1 <= old.length() - 2) {
                        String pre = old.substring(0, i + 1);
                        map.put(pre, old);
                        int index = Integer.valueOf(old.substring(old.length() -1));
                        prefixes[index] = pre;
                    } else {
                        map.put(p, old);
                    }
                }
            }
        }

        return Arrays.asList(prefixes);
    }

    /*
    1) Construct a Trie of all words. Also maintain frequency of every node (Here frequency is number of times node is visited during insertion).
    Time complexity of this step is O(N) where N is total number of characters in all words.

2) Now, for every word, we find the character nearest to the root with frequency as 1.
The prefix of the word is path from root to this character. To do this, we can traverse Trie starting from root. For every node being traversed, we check its frequency.
If frequency is one, we print all characters from root to this node and don’t traverse down this node.

Time complexity if this step also is O(N) where N is total number of characters in all words.
     */

    static final int MAX  = 256;

    // Maximum length of an input word
    static final int MAX_WORD_LEN = 500;

    // Trie Node.
    static class TrieNode
    {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency
        TrieNode() {
            freq =1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }
    static TrieNode root;

    // Method to insert a new string into Trie
    static void insert(String str)
    {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;

        // Traversing over the length of given str.
        for (int level = 0; level<len; level++)
        {
            // Get index of child node from current character
            // in str.
            int index = str.charAt(level);

            // Create a new child if not exist already
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;

            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }

    // This function prints unique prefix for every word stored
    // in Trie. Prefixes one by one are stored in prefix[].
    // 'ind' is current index of prefix[]
    static void findPrefixesUtil(TrieNode root, char[] prefix,
                                 int ind)
    {
        // Corner case
        if (root == null)
            return;

        // Base case
        if (root.freq == 1)
        {
            prefix[ind] = '\0';
            int i = 0;
            while(prefix[i] != '\0')
                System.out.print(prefix[i++]);
            System.out.print("  ");
            return;
        }

        for (int i=0; i<MAX; i++)
        {
            if (root.child[i] != null)
            {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind+1);
            }
        }
    }

    // Function to print all prefixes that uniquely
    // represent all words in arr[0..n-1]
    static void findPrefixes(String arr[], int n)
    {
        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i<n; i++)
            insert(arr[i]);

        // Create an array to store all prefixes
        char[] prefix = new char[MAX_WORD_LEN];

        // Print all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0);
    }

}
