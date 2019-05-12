package daily2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string.
For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].

@Microsoft

@medium

@solved
@10min

 */
public class D20190502 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPattern("abracadabra", "abr")));
    }


    // O(n * k)
    public static int[] findPattern(String str, String pattern) {
        char[] pcs = pattern.toCharArray();
        char[] scs = str.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < scs.length - pcs.length; i++) {
            if (scs[i] == pcs[0]) {
                int j = i + 1;
                for (;j < i + pcs.length; j++) {
                    if (scs[j] != pcs[j -i ]) break;
                }
                if (j == i + pcs.length) res.add(i);
            }
        }
        int[] resI = new int[res.size()];
        for (int i = 0; i < res.size(); i++) resI[i] = res.get(i);
        return resI;
    }

    // optimize? faster?

}
