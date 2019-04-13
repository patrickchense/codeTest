package dailyproblem;


/*
An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.

@Amazon

@serach
@binarysearch
@answered
@review

https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

Input arr[] = {3, 4, 5, 1, 2}
Element to Search = 1
  1) Find out pivot point and divide the array in two
      sub-arrays. (pivot = 2)
  2) Now call binary search for one of the two sub-arrays.
          (a) If element is greater than 0th element then
          search in left array
          (b) Else Search in right array
          (1 will go in else as 1 < 0th element(3))
        3) If element is found in selected sub-array then return index
        Else return -1.



 */
public class Daily20181201 {

    public static void main(String[] args) {
        System.out.println(find(new int[]{13, 18, 25, 2, 8, 10}, 8));
        System.out.println(find(new int[]{12, 18, 25, 2, 8, 10}, 10));
        System.out.println(find(new int[]{12, 18, 25, 2, 8, 10}, 12));
    }

    // not sorted, can't work simple binary search
    // 有几个坑，1是判断
    /* mid 的几种情况，   < end , < start,
    //                          end < start,   target <= end  start = mid
    //                                         else  end = mid
//                                start < end
                        > end > start,  target > start
                                        target < end

       */
    public static Integer find(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end + 1) >> 1;
            if (arr[mid] == target) return mid;
            if (target >= arr[start]) end = mid -1 ;
            else start = mid + 1;
        }
        return null;
    }

    /* Searches an element key in a
       pivoted sorted array arrp[]
       of size n */
    static int pivotedBinarySearch(int arr[], int n, int key)
    {
        int pivot = findPivot(arr, 0, n-1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n-1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, n-1, key);
    }


    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid -1), key);
    }
}
