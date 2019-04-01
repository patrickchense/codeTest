package dailyproblem;

/*
Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word.
If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome).
 There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".

@quora
@dp
@solved
https://kennyzhuang.gitbooks.io/algorithms-collection/content/shortest_palindrome.html

related
https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/

 */
public class Daily20181107 {

    /*
    key point, what's shortest?
Let the input string be str[l……h]. The problem can be broken down into three parts:
1. Find the minimum number of insertions in the substring str[l+1,…….h].
2. Find the minimum number of insertions in the substring str[l…….h-1].
3. Find the minimum number of insertions in the substring str[l+1……h-1].
     */
    public static String shortestPalindrome(String s) {
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }

        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("race"));
        System.out.println(shortestPalindrome("godeogle"));
    }
}
