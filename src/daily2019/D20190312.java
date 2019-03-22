package daily2019;

/*
Given a string, return the first recurring character in it, or null if there is no recurring character.

For example, given the string "acbbac", return "b". Given the string "abcdef", return null.

@Google
@solved
@review
@string
@find

find string 相关一些
https://www.geeksforgeeks.org/efficiently-find-first-repeated-character-string-without-using-additional-data-structure-one-traversal/  bit操作
https://www.geeksforgeeks.org/find-one-extra-character-string/
https://www.geeksforgeeks.org/first-non-repeating-character-using-one-traversal-of-string-set-2/
https://www.geeksforgeeks.org/efficiently-check-string-duplicates-without-using-additional-data-structure/
https://www.geeksforgeeks.org/count-occurrences-of-a-character-in-a-repeated-string/
https://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
https://www.geeksforgeeks.org/find-last-index-character-string/

 */
public class D20190312 {
    public static void main(String[] args) {
        System.out.println(firstRecurring("acbbac"));
        System.out.println(firstRecurring("abcdef"));
    }

    public static Character firstRecurring(String s) {
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) return c;
            c = s.charAt(i);
        }
        return null;
    }
}
