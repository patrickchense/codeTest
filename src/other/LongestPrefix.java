package other;

import util.TrieNode;

import java.util.Map;

/*
https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
@trie

We build a Trie of all dictionary words. Once the Trie is built, traverse through it using characters of input string.
 If prefix matches a dictionary word, store current length and look for a longer match. Finally, return the longest match.
Following is Java implementation of the above solution based.
 */
public class LongestPrefix {

    // The main method that finds out the longest string 'input'
    public static String getMatchingPrefix(TrieNode root, String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string

        // Initialize reference to traverse through Trie
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ )
        {
            // Find current character of str
            char ch = input.charAt(level);

            // HashMap of current Trie node to traverse down
            Map<Object,TrieNode> child = crawl.children;

            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
                result += ch;          //Update result
                crawl = child.get(ch); //Update crawl to move down in Trie

                // If this is end of a word, then update prevMatch
                if( crawl.isEnd )
                    prevMatch = level + 1;
            }
            else  break;
        }

        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if( !crawl.isEnd )
            return result.substring(0, prevMatch);

        else return result;
    }

    public static void main(String[] args) {
        TrieNode dict = new TrieNode();
        dict.insert(dict,"are");
        dict.insert(dict,"area");
        dict.insert(dict,"base");
        dict.insert(dict, "cat");
        dict.insert(dict,"cater");
        dict.insert(dict,"basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(getMatchingPrefix(dict,input));
    }
}
