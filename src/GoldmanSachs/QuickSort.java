package GoldmanSachs;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 77, 4, 6, 45, 44, 23, 75, 99, 20, 19, 76, 34};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{8, 7, 5, 4, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{8, 7, 5, 4, 2, 1, 20};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        // without recursion
        nums = new int[]{1, 5, 3, 77, 4, 6, 45, 44, 23, 75, 99, 20, 19, 76, 34};
        iterativeQsort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{8, 7, 5, 4, 2, 1};
        iterativeQsort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{8, 7, 5, 4, 2, 1, 20};
        iterativeQsort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void quickSort(int[] nums, int low, int high) {
/*        if (nums == null || nums.length <= 1 || low > high) return;
        int i = low, j = high, pivot = nums[(low + high) / 2];
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (i == j) i++;
        }
        quickSort(nums, low, i);
        quickSort(nums, j, high);*/
        if (low < high) {
//             pi is partitioning index, arr[pi] is
//              now at right place
            int pi = partition(nums, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                System.out.printf("a[%d]=%d, a[%d]=%d\n", i, arr[i], j, arr[j]);
                // swap arr[i] and arr[j]
                if (i != j) swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        System.out.printf("i+1=%d, high=%d\n", i + 1, high);
        if (i + 1 != high) swap(arr, i+1, high);

        return i + 1;
    }

    public static void iterativeQsort(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(numbers.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
    } /* * Utility method to partition the array into smaller array, and * comparing numbers to rearrange them as per quicksort algorithm. */

    private static int partition(int[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l] < piv) {
                l++;
            } else if (input[h] >= piv) {
                h--;
            } else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    /**
     * Utility method to swap two numbers in given array * * @param arr - array on which swap will happen * @param i * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
