package daily2019;

import java.util.HashSet;
import java.util.Set;

/*
Determine whether there exists a one-to-one character mapping from one string s1 to another s2.

For example, given s1 = abc and s2 = bcd, return true since we can map a to b, b to c, and c to d.

Given s1 = foo and s2 = bar, return false since the o cannot map to two characters.

@easy
@solved
@string
@15min

尝试用XOR,没成功，存在不用O(n)空间的方式吗？
https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/  这里没有

@review
@twostring

相关的问题:
https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
https://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
https://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings/
https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/

简单理解为，不存在重复字符
 */
public class D20190329 {

    public static void main(String[] args) {
        System.out.println(isOneToOne2("abc", "bcd"));
        System.out.println("---");
        System.out.println(isOneToOne2("foo", "bar"));
    }


    // XOR not working???
    public static boolean isOneToOne(String str1, String str2) {
        char a = 0;
        for (int i = 0; i < str1.length(); i++) {
            a ^= str1.charAt(i);
        }
        if (a != 0) return false;
        a = 0;
        for (int i = 0; i < str1.length(); i++) {
            a ^= str1.charAt(i);
        }
        return a == 0;
    }

    public static boolean isOneToOne2(String str1, String str2) {
        Set<Character> characters = new HashSet<>();
        for (int i =0; i < str1.length(); i++) {
            boolean exits = characters.add(str1.charAt(i));
            if (!exits) return false;
        }
        characters.clear();
        for (int i =0; i < str2.length(); i++) {
            boolean exits = characters.add(str2.charAt(i));
            if (!exits) return false;
        }
        return true;
    }
}
