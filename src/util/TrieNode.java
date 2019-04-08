package util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Object value;
    public Map<Object,TrieNode> children = new HashMap<>();
    public boolean isEnd;


    public void insert(TrieNode root, String word)  {

        // Find length of the given word
        int length = word.length();
        TrieNode crawl = root;

        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            Map<Object,TrieNode> child = crawl.children;
            char ch = word.charAt(level);

            // If there is already a child for current character of given word
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {
                TrieNode temp = new TrieNode();
                temp.value = ch;
                child.put( ch, temp );
                crawl = temp;
            }
        }

        // Set bIsEnd true for last character
        crawl.isEnd = true;
    }
}
