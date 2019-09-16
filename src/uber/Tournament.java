package uber;

/*
Given an array arr of unique integers [1..n]. The array represents n different players at a tournament and their overall strength,
 and the first two slots in the array represent the current match. The stronger player always wins and the weaker player is moved to the end of the array.
 The tournament ends when a player wins k matches in a row. Find the winner.

Example:

Input: arr = [2, 1, 3, 4, 5], k = 2
Output: 5
Explanation:
[2 1] 3 4 5 | player 2 vs. player 1, player 2 wins and player 1 is moved to the end
[2 3] 4 5 1 | player 2 vs. player 3, player 3 wins
[3 4] 5 1 2 | player 4 wins
[4 5] 1 2 3 | player 5 wins
[5 1] 2 3 4 | player 5 wins again, that's k times in a row so 5 is the overall winner
Expected O(n) time and O(1) space solution. arr is immutable.

@phone
@solved

 */
public class Tournament {

	public static void main(String[] args) {
		System.out.println(findWinner(new int[]{2,1,3,4,5}, 2));
		System.out.println(findWinner(new int[]{2,1,3,1,5}, 2));
		System.out.println(findWinner(new int[]{2,1,3,1,2,5}, 3));
	}

	public static int findWinner(int[] nums, int target) {
		int max = Math.max(nums[0], nums[1]);
		int count = 1;
		for (int i = 2; i < nums.length; i++) {
			 if (max > nums[i]) {
			 	count++;
			 	if (count == target) return max;
			 }
			 else {
			 	max = nums[i];
			 	count = 1;
			 }
		}
		return max;
	}
}
