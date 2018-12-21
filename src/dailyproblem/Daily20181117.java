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
 */
public class Daily20181117 {

    public static void main(String[] args){
        int[] arr = new int[]{2, 4, 1, 3, 5};
        System.out.println(countInversions(arr));
        System.out.println(countInversions(new int[]{5, 4, 3, 2, 1}));

    }

    /*
        sort, find number index in the ordered arr, then if (index > cur_index) index - cur_index is the number inversions about this number.
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
}
