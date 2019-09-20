package daily2019;

/*
You have N stones in a row, and would like to create from them a pyramid. This pyramid should be constructed such that the height of each stone increases by one until reaching the tallest stone,
after which the heights decrease by one. In addition, the start and end stones of the pyramid should each be one stone high.

You can change the height of any stone by paying a cost of 1 unit to lower its height by 1, as many times as necessary. Given this information, determine the lowest cost method to produce this pyramid.

For example, given the stones [1, 1, 3, 3, 2, 1], the optimal solution is to pay 2 to create [0, 1, 2, 3, 2, 1].

@Uber
@hard
@dp
https://www.geeksforgeeks.org/pyramid-form-increasing-decreasing-consecutive-array-using-reduce-operations/


 */
public class D20190723 {


	public static void main(String[] args) {

	}

	/*
	By modifying the above algorithm slightly, we can attempt to get an O(N) approach. Start at the left, and moving right, find the maximum possible height pyramid that can be created at that position.
	 Assume that the part of the array to the right of that position is a mirror image of the left. If H(i) is the height of stone at position i, then maxHeight(i) = Minimum(H(i), i, maxHeight(i – 1))
This can be explained as follows:
The maximum possible height cannot exceed H(i) as we can only decrease the height of stone, not increase.
The maximum possible height cannot exceed i, as the pyramid has to start from a height 1.
The maximum possible height cannot exceed the maximum possible height of the stone before it – 1, as the stones have to increase by 1 for each step.

We calculate a similar value moving from right to left. We then take the minimum of these values for each position. Then by identifying the maximum, we can calculate the minimum cost of constructing a pyramid.

这个解释是给只能减，不能加的题型
	 */


	// 能加能减
	public static int cost(int[] nums) {

		return 0;
	}


}
