package dailyproblem;

/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height.
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index
 (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

@facebook


 */
public class Daily20181103 {

    /*
    find the one >= index[0]
        count += index[0] - index[i]
        wall_index = i

        2, 1, 2  =>  lagest two is 2,2
        3, 0, 1, 3, 0, 5] => 3, 3, 5
        3, 4, 1, 5, 0, 3 =>  3, 4, 5, 3
        5, 0, 3, 2, 1 =>
     */
    public static int holdUnitWater(int[] nums) {
        int unit = 0;
        int wallIndex = 0;
        for (int i = 1; i < nums.length; i++) {

        }
        return unit;
    }
}
