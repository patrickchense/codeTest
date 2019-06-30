package leetcode.arr;

import java.util.*;

/*
https://leetcode.com/problems/reordered-power-of-2/

Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.



Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true

@solved
@array
@optimize


 */
public class LT_ReorderedPowerOf2 {
    static Map<Integer, Set<char[]>> nums = new HashMap<>();
    static {
        for (int i = 0; i <= 31; i++) {
            int t = (int)Math.pow(2, i);
            String tmp = String.valueOf(t);
            char[] cs = tmp.toCharArray();
            Arrays.sort(cs);
            if (nums.containsKey(tmp.length())) {
                nums.get(tmp.length()).add(cs);
            } else {
                Set<char[]> chars = new HashSet<>();
                chars.add(cs);
                nums.put(tmp.length(), chars);
            }
        }
    }
    public boolean reorderedPowerOf2(int N) {
        String ns = String.valueOf(N);
        if (nums.containsKey(ns.length())) {
            Set<char[]> t = nums.get(ns.length());
            char[] nsc = ns.toCharArray();
            Arrays.sort(nsc);
            for (char[] tc : t) {
                boolean isMatch = true;
                for (int i = 0; i < nsc.length; i++) {
                    if (nsc[i] != tc[i]) {
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch) return true;

            }
        }
        return false;
    }

    //try optimize? no sort
    public boolean reorderedPowerOf21(int N) {
        int[] ncount = count(N);
        for(int i = 0; i <= 30; i++){
            if(Arrays.equals(ncount, count(1<<i))) return true;
        }
        return false;
    }

    private int[] count(int N){
        int[] ans = new int[10];
        while(N > 0){
            ans[N%10]++;
            N /= 10;
        }
        return ans;
    }
}
