package GoldmanSachs;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 77, 4, 6, 45, 44, 23, 75, 99, 20, 19, 76, 34};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{8,7,5,4,2,1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void quickSort(int[] nums, int low, int high) {
/*        if (nums == null || nums.length <= 1 || low > high) return;
        int i = low, j = high, pivot = nums[(low + high) / 2];
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i < j) {
                //swap
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            } else if (i == j) i++;
        }
        quickSort(nums, low, i);
        quickSort(nums, j, high);*/
        if (low < high)
        {
//             pi is partitioning index, arr[pi] is
//              now at right place
            int pi = partition(nums, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(nums, low, pi-1);
            quickSort(nums, pi+1, high);
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

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
