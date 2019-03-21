package daily2019;


import java.util.*;

/**
 Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.

 For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:

 There is 1 smaller element to the right of 3
 There is 1 smaller element to the right of 4
 There are 2 smaller elements to the right of 9
 There is 1 smaller element to the right of 6
 There are no smaller elements to the right of 1

 @Google
 @nosolve
 @again
 https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
 */
public class D20190318 {

    public static void main(String[] args) {
        int[] arrs = new int[]{3, 4, 9, 6, 1};
        System.out.println(Arrays.toString(rightSmallerCount(arrs)));
    }

    //不对，逻辑有问题， 6不能计算出来
    public static int[] rightSmallerCount(int[] arrs) {
        int[] result = new int[arrs.length];
        Map<Integer, Integer> ii = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) ii.put(arrs[i], i);
        Arrays.sort(arrs); //O(nlogn)
        //assume uniques
        for (int i = 0; i < arrs.length; i++) {
            int index = ii.get(arrs[i]);
            if (i > index) result[index] = i - index;
            else result[index] = 0;
        }
        return result;
    }

    // Time Complexity: O(nLogn)
    //Auxiliary Space: O(n)
    // 不用 TreeMap
    int[] cnt;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        cnt = new int[n];
        List<Integer> ans = new ArrayList<>();
        int[][] copy = new int[n][2];
        for(int i = 0; i < n; i++)
            copy[i] = new int[]{nums[i], i};
        ms(copy, 0, n-1);
        for(int i = 0; i < n; i++)
            ans.add(cnt[i]);

        return ans;
    }

    public void ms(int[][] nums, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        ms(nums, left, mid);
        ms(nums, mid+1, right);
        for(int i = left, j = mid + 1; i <= mid; i++){
            while(j <= right && nums[j][0] < nums[i][0])
                j++;
            cnt[nums[i][1]] += (j - (mid + 1));
        }

        merge(nums, left, mid, right);
    }

    public void merge(int[][] nums, int left, int mid, int right){
        int p1 = left, p2 = mid + 1, i = 0;
        int[][] buffer = new int[right - left  + 1][2];
        while(i < buffer.length){
            if(p2 > right)
                buffer[i++] = nums[p1++];
            else if(p1 > mid)
                buffer[i++] = nums[p2++];
            else if(nums[p1][0] < nums[p2][0])
                buffer[i++] = nums[p1++];
            else
                buffer[i++] = nums[p2++];
        }

        for(int j = left; j <= right; j++)
            nums[j] = buffer[j-left];
    }

}
