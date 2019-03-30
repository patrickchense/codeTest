package daily2019;

import java.util.Arrays;
import java.util.List;

/*
Given a number in the form of a list of digits, return all possible permutations.

For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

@microsoft
@array
@permutation
@review

https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/

计算Kth的逻辑
也就是说，可以根据k的大小来判断每一个数位的字符（从最大数位开始，因为默认factorio从最大数位开始变化）。
于是先求出n!， 然后 k/n!就可以推算出当下这一个数位的字符。然后分别把factorio 和 k减小。
另外, 用一个boolean[] visited来确保每个数字只出现一次。
这个方法比计算出每个permutation要efficient许多。

O(n!) time

关联的
https://www.geeksforgeeks.org/permutations-string-using-iteration/
https://www.geeksforgeeks.org/number-of-palindromic-permutations-set-1/
https://www.geeksforgeeks.org/problem-permutations-combinations-set-2/
https://www.geeksforgeeks.org/print-k-different-sorted-permutations-of-a-given-array/
https://www.geeksforgeeks.org/print-k-different-sorted-permutations-of-a-given-array/

 */
public class D20190108 {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        permutations(a, a.length, a.length);
        permutations(new int[]{3, 6,8,19, 20}, 5, 5);
    }

    // recrusive?
    // 先替换前三位，然后2-4位，1，3，4位，124位，
    public static void permutations(int a[], int size, int n) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            System.out.println(Arrays.toString(a));

        for (int i=0; i<size; i++)
        {
            permutations(a, size-1, n);
            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            }

            // If size is even, swap ith and last
            // element
            else
            {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
    }
}
