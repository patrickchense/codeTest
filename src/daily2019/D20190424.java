package daily2019;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. Find the minimum element in O(log N) time. You may assume the array does not contain duplicates.

For example, given [5, 7, 10, 3, 4], return 3.

@Uber
@medium
@rotate
@array
@findmin
@ordered
@binarysearch

@solved
@10min
 */
public class D20190424 {

    public static void main(String[] args) {
        System.out.println(findMinium(new int[]{5,7,10,3,4}, 0, 4));
        System.out.println(findMinium(new int[]{7,8,9,10,3,4,5,6}, 0, 7));
    }

    // 变形的binary search
    public static int findMinium(int[] nums, int i, int j) {
        if (j -i == 1) return Math.min(nums[i], nums[j]);
        if (j == i) return nums[i];
        int mid = (i + j) >> 1;
        if (nums[mid] > nums[j]) {
            return findMinium(nums, mid+1, j);
        }
        else {
            return findMinium(nums, i, mid - 1);
        }
    }
}
