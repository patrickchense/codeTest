package daily2019;

/*
Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.

For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.

@Pinterest
@dp
@array
@solved

找到公式就行

 */
public class D20190118 {

    public static void main(String[] args) {
        System.out.println(isReachable(new int[]{2, 0, 1, 0}));
        System.out.println(isReachable(new int[]{1, 1, 0, 1}));
    }

    /*
    dp问题，能否到最后的关键在于, 步数够不够，也就是d(n-1) > 1 就可以
    dn = d(n-1) -1 + a[i]
     */
    public static boolean isReachable(int[] arr) {
        int[] d = new int[arr.length-1];
        d[0] = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (d[i-1] < 1) return false;
            d[i] = d[i-1] -1 + arr[i];
        }
        return d[d.length-1] >= 1;
    }
}
