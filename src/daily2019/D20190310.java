package daily2019;

/*
Given a string, determine whether any permutation of it is a palindrome.

For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome.
daily should return false, since there's no rearrangement that can form a palindrome.

@Amazon
@solved

@palindrome
@string

https://www.geeksforgeeks.org/print-all-palindrome-permutations-of-a-string/ 所有组合?
https://www.geeksforgeeks.org/print-palindromic-permutations-given-string-alphabetic-order/
https://www.geeksforgeeks.org/permutations-string-using-iteration/
https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
https://www.geeksforgeeks.org/convert-string-palindrome-string-changing-one-character/
https://www.geeksforgeeks.org/permutations-of-a-given-string-using-stl/

 */
public class D20190310 {
    public static void main(String[] args) {
        System.out.println(possiblePalindrome("carrace"));
        System.out.println(possiblePalindrome("daily"));
        System.out.println(possiblePalindrome("daiiiilllyya"));
        System.out.println(possiblePalindrome("aiiiilllyya"));
    }

    // 关键在于字符数量是否even，允许一个odd
    public static boolean possiblePalindrome(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()) {
            int t = c - 'a';
            if (arr[t] == 0) arr[t] = t;
            else {
                arr[t] -= t;
            }
        }
        int count = 0;
        for (int a : arr) {
            if (a > 0) count++;
        }
        return count <= 1;
    }
}
