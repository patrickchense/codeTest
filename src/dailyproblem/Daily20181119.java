package dailyproblem;

import util.StringUtil;

/*
Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".

@Amazon
@string
@substring
@palindrome
@answered
@review

这里体现了palindrome的关键， 两个while循环，分别判断双数和单数的长度下的palindrome，就是这么做
https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/

https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/ dp O(n^2) O(n^2)
The time complexity can be reduced by storing results of subproblems. The idea is similar to this post. We maintain a boolean table[n][n] that is filled in bottom up manner.
 The value of table[i][j] is true, if the substring is palindrome, otherwise false. To calculate table[i][j], we first check the value of table[i+1][j-1],
 if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.


 */
public class Daily20181119 {

    public static void main(String[] args) {
        System.out.println(longestPalindromicString("aabcdcb"));
        System.out.println(longestPalSubstr("bananas"));
    }

    // O(n^2) O(1)
    public static String longestPalindromicString(String str) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return str.substring(start, start + maxLength);
    }

    static String longestPalSubstr(String str) {
        int n = str.length();   // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) ==
                        str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start, start + maxLength); // return length of LPS
    }
}
