package leetcode.dp;

/*
https://leetcode.com/problems/stone-game-ii/

Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.

Alex and Lee take turns, with Alex starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.



Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.


@dp
@review
@recursive

这种题目还是要递归的去找，dp保存信息
 */
public class LT1140_StoneGameII {

	public int stoneGameII(int[] p) {
		int[] sum = new int[p.length];
		for(int i = p.length - 1; i >= 0; i--) {
			sum[i] += (i + 1 < p.length ? sum[i + 1] : 0) + p[i];  // from end of the array, addup
		}
		int[][] mem = new int[p.length][2*p.length]; // dp
		return helper(p, 0, 1, mem, sum);
	}

	int helper(int[] p, int idx, int M, int[][] mem, int[] sum) {
		if(idx == p.length) return 0;
		if(p.length - idx <= 2*M) return sum[idx]; // enough， get rest all
		if(mem[idx][M] != 0) return mem[idx][M];

		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= 2*M; i++) {
			min = Math.min(min, helper(p, idx + i, Math.max(M, i), mem, sum)); // find the min sum in the rest arr
		}
		mem[idx][M] = sum[idx] - min; // the biggest
		return mem[idx][M];
	}
}
