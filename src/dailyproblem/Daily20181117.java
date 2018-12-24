package dailyproblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

@google
@answered
https://www.geeksforgeeks.org/counting-inversions/

 */
public class Daily20181117 {

    public static void main(String[] args){
        int[] arr = new int[]{2, 4, 1, 3, 5};
        System.out.println(countInversions2(arr));
        System.out.println(countInversions2(new int[]{5, 4, 3, 2, 1}));

    }

    /*
        sort, find number index in the ordered arr, then if (index > cur_index) index - cur_index is the number inversions about this number.

        @wrong
     */
    public static int countInversions(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        Map<Integer, Integer> indexes = new HashMap<>();
        int count = 0;
        for (int i = 0; i < tmp.length; i++) {
            indexes.put(tmp[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int index = indexes.get(arr[i]);
            if (index > i) count += index -i;
            else if (index < i) count -= i - index;
        }
        return count;
    }

    /*
    merge sort
     */
    public static int countInversions2(int[] arr) {
        int temp[] = new int[arr.length];
        return _mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static int _mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left ) / 2 ;
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid+1, right);

            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    /*
    @keypoint
    逻辑:
        In merge process, let i is used for indexing left sub-array and j for right sub-array. At any step in merge(),
        if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted,
         so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]

     */
    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;
        i = left;
        j = mid;
        k = left;
        while ( (i <= mid - 1) && ( j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                inv_count += mid - i; // count inversions,
            }
        }

        while (i <= mid -1) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i=left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inv_count;
    }
}
