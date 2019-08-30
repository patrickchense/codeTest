package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.



Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4

@dp
@binarytree
@review
@optimize
 */
public class LT1130_MinCostTreeFromLeaf {

	// find the minimal a * b, and replace index i with index(max(a,b)),  remove the smaller i
	public int mctFromLeafValues(int[] arr) {
		int res=0;
		List<Integer> list = new ArrayList<Integer>();
		for(int val : arr)
			list.add(val);

		while(list.size() != 1){
			int best_mul = Integer.MAX_VALUE;
			int best_ind = -1;
			for(int i=0;i<list.size()-1;i++){
				int a = list.get(i);
				int b = list.get(i+1);
				if(a*b < best_mul){
					best_mul = a*b;
					best_ind = i;
				}
			}

			int max = Math.max(list.get(best_ind),list.get(best_ind+1));
			res += best_mul;
			list.remove(best_ind);
			list.set(best_ind, max);
		}

		return res;


	}

	// slower
	public int mctFromLeafValuesDP(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		int[][] max = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; i ++) {
			int localMax = 0;
			for(int j = i; j < arr.length; j ++) {
				if(arr[j] > localMax) {
					localMax = arr[j];
				}
				max[i][j] = localMax;
			}
		}
		for(int len = 1; len < arr.length; len ++) {
			for(int left = 0; left + len < arr.length; left ++) {
				int right = left + len;
				dp[left][right] = Integer.MAX_VALUE;
				if(len == 1) {
					dp[left][right] = arr[left]*arr[right];
				} else {
					for(int k = left; k < right; k ++) {
						dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
					}
				}
			}
		}
		return dp[0][arr.length-1];
	}


	// fast, 用sort的方式，不需要额外的空间，O(nlogn)最快，理解逻辑，每次找到左右最大，然后保留product
	int res = 0;
	public int mctFromLeafValuesDivideConqur(int[] arr) {
		mergesort(arr, 0, arr.length - 1);
		return res;
	}

	private void mergesort(int[] arr, int low, int high) {
		if (low >= high) return;
		int maxIndex = low, maxNum = Integer.MIN_VALUE;
		for (int i = low; i <= high; i++) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
				maxIndex = i;
			}
		}
		if (maxIndex == high) maxIndex--;
		mergesort(arr, low, maxIndex);
		mergesort(arr, maxIndex + 1, high);

		int leftMax = maxIndex >= low ? arr[maxIndex] : 0;
		int rightMax = maxIndex + 1 <= high ? arr[high]: 0;
		res += leftMax * rightMax;
		Arrays.sort(arr, low, high + 1);
	}
}
