package leetcode.str;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/reverse-only-letters/


 @easy
 @string
@solved

 */
public class LT917_Reverse_Only_Letters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("7_28]"));
    }



    public static String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        Map<Integer,Character> ops = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (!((cs[i] <= 'z' && cs[i] >= 'a') || (cs[i] >= 'A' && cs[i] <= 'Z'))) {
                ops.put(i, cs[i]);
            }
        }
        int i = 0;
        int j = cs.length-1;
        while(i < j) {
            if (ops.containsKey(i)) {
                i++;
                continue;
            }
            if (ops.containsKey(j)) {
                j--;
                continue;
            }
            char c = cs[i];
            cs[i++] = cs[j];
            cs[j--] = c;
        }
        return new String(cs);
    }
}
