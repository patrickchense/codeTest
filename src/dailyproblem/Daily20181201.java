package dailyproblem;


/*
An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.

@Amazon

@serach
@binarysearch

 */
public class Daily20181201 {

    public static void main(String[] args) {
        System.out.println(find(new int[]{13, 18, 25, 2, 8, 10}, 8));
        System.out.println(find(new int[]{12, 18, 25, 2, 8, 10}, 10));
        System.out.println(find(new int[]{12, 18, 25, 2, 8, 10}, 12));
    }

    // not sorted, can't work simple binary search
    // 有几个坑，1是判断
    // 这里的逻辑还是有问题，没想清楚
    public static Integer find(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end + 1) >> 1;
            if (arr[mid] == target) return mid;
            else if (arr[start] <= target) {
                end = mid;
            }
            else
                start = mid;
        }
        return null;
    }
}
