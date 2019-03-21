package daily2019;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a list of words, find all pairs of unique indices such that the concatenation of the two words is a palindrome.

For example, given the list ["code", "edoc", "da", "d"], return [(0, 1), (1, 0), (2, 3)].

@Airbnb

@solved

 关联
 https://www.geeksforgeeks.org/given-two-strings-check-string-makes-palindrome-first/
 https://www.geeksforgeeks.org/count-palindrome-sub-strings-string-set-2/ 计算substr的palindrome数量
 */
public class D20190320 {

    public static void main(String[] args) {
        String[] strs = new String[]{"code", "edoc", "da", "d"};
        ArrayUtil.printList(palindromePair(strs));
        strs = new String[]{"code", "edoc", "dabcb", "ad", "accc", "a"};
        ArrayUtil.printList(palindromePair(strs));

        System.out.println(countPS("abaab"));
        System.out.println(countPS("abbaeae"));
    }


    public static List<List<Integer>> palindromePair(String[] strs) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                int palindrome = isPalindrome(strs[i], strs[j]);
                if (palindrome == 1) {
                    results.add(Arrays.asList(i, j));
                } else if (palindrome == 2) {
                    results.add(Arrays.asList(i, j));
                    results.add(Arrays.asList(j, i));
                }
            }
        }
        return results;
    }

    // how to define palindrome?
    // s[0] == s[len-1] ...
    // if len1 != len2  sub_str(min(len), max(len)) is palindrome
    // O(1)空间, O(n) time
    public static int isPalindrome(String str1, String str2) {
        int i,j;
        for (i = 0, j = str2.length()-1; i < str1.length() && j >= 0; i++, j--) {
            if (str1.charAt(i) != str2.charAt(j)) return -1;
        }
        if (str1.length() == str2.length()) return 2;
        if (Math.abs(str1.length()-str2.length()) == 1) return 1;
        int leftLen = Math.abs(i-j);
        int mid = leftLen >> 1;
        boolean isEven = mid << 2 == leftLen;
        int rightIndex = isEven ? mid : mid + 1;
        if (str1.length() > str2.length()) {
            return isPalindrome(str1.substring(str2.length(), str2.length() + mid), str1.substring(str2.length() + rightIndex));
        } else {
            return isPalindrome(str2.substring(str1.length(), str1.length() + mid), str2.substring(str1.length() + rightIndex));
        }
    }

    // 这个判断palindrome, O(n)空间，O(n) time
    static char stringPalindrome(String A, String B)
    {
        // Count frequencies of characters in
        // both given strings
        int[] countA = new int[26];
        int[] countB = new int[26];

        int l1 = A.length();
        int l2 = B.length();

        for (int i = 0; i < l1; i++)
            countA[A.charAt(i) - 'a']++;

        for (int i = 0; i < l2; i++)
            countB[B.charAt(i) - 'a']++;

        // Check if there is a character that
        // appears more than once in A and does
        // not appear in B
        for (int i = 0; i < 26; i++)
            if ((countA[i] > 1 && countB[i] == 0))
                return 'A';

        return 'B';
    }

    static int countPS(String str){
        String temp = "";
        StringBuffer stf;
        int count = 0;
        // Iterate the loop twice
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                // Get each substring
                temp = str.substring(i, j);

                // If length is greater than or equal to two
                // Check for palindrome
                if (temp.length() >= 2) {
                    // Use StringBuffer class to reverse the string
                    stf = new StringBuffer(temp);
                    stf.reverse();
                    // Compare substring wih reverse of substring
                    if (stf.toString().compareTo(temp) == 0)
                        count++;
                }
            }
        }
        // return the count
        return count;
    }
}
