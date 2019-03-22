package daily2019;

import java.util.Arrays;

/**
 * You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}.
 * By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.
 *
 * @Google
 * @solved
 *
 * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/ O(1) space
 */
public class D20190317 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,4,5,6};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicate2(arr));
        arr = new int[]{1,2,8,3,4,5,6,7,6};
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicate2(arr));
    }

    // O(n) time O(n) space
    static int findDuplicate(int[] arr) {
        int[] pos = new int[arr.length - 1];
        int n = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            pos[arr[i]-1]++;
        }
        for (int i = 0; i < n ; i++) if (pos[i] != 1) return i + 1;
        return -1;
    }

    /*
    traverse the list for i= 0 to n-1 elements
{
  check for sign of A[abs(A[i])] ;
  if positive then
     make it negative by   A[abs(A[i])]=-A[abs(A[i])];
  else  // i.e., A[abs(A[i])] is negative
     this   element (ith element of list) is a repetition

     就是通过index来把遇到的都弄反，然后下次再碰到反的，就是重复的
}
     */

    public static int findDuplicate2(int[] arr) {
        int i;
        int size = arr.length;
        for (i = 0; i < size; i++)
        {
            System.out.println(arr[Math.abs(arr[i])]);
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
                System.out.println(Arrays.toString(arr));
            }
            else {
                return Math.abs(arr[i]);
            }
        }
        return -1;
    }
}
