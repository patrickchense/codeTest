package dailyproblem;

/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height.
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index
 (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

@facebook
@array
@dp
@answered
@review

https://www.geeksforgeeks.org/trapping-rain-water/

不会

related:
https://www.geeksforgeeks.org/maximum-litres-of-water-that-can-be-bought-with-n-rupees/
https://www.geeksforgeeks.org/amazon-pune-pool-campus-interview/
https://www.geeksforgeeks.org/find-maximum-sum-taking-every-kth-element-in-the-array/
https://www.geeksforgeeks.org/find-the-minimum-number-of-operations-required-to-make-all-array-elements-equal/


 */
public class Daily20181103 {

    public static void main(String[] args) {
        System.out.println(findWater(new int[]{2,1,2}, 3));
        System.out.println(findWater(new int[]{3, 0, 1, 3, 0, 5}, 6));
        System.out.println(findWaterSpaceOptimize(new int[]{2,1,2}, 3));
        System.out.println(findWaterSpaceOptimize(new int[]{3, 0, 1, 3, 0, 5}, 6));
    }


    // O(n) O(n)
    //An Efficient Solution is to prre-compute highest bar on left and right of every bar in O(n) time. Then use these pre-computed values to find the amount of water in every array element
    static int findWater(int[] arr, int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], arr[i]);

        // Fill right array
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i],right[i]) - arr[i];

        return water;
    }

    /*
    Space Optimization in above solution :
Instead of maintaing two arrays of size n for storing left and right max of each element,
we will just maintain two variables to store the maximum till that point. Since water trapped at
 any element = min( max_left, max_right) – arr[i] we will calculate water trapped on smaller element out of A[lo]
 and A[hi] first and move the pointers till lo doesn’t cross hi.

 用类似2指针的方式，找左边和右边的最大，然后统计
     */
    static int findWaterSpaceOptimize(int arr[], int n)
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n-1;

        while(lo <= hi)
        {
            if(arr[lo] < arr[hi])
            {
                if(arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else
            {
                if(arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }
}
