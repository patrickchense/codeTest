package leetcode.arr;

/*
https://leetcode.com/problems/maximum-swap/
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

@array
@greedy
@review

占位法，一共10个数字，int[10] 可以处理这种情况，然后可以对应数字的排序（倒序的话）

占位法的关键在于，找到可以逆向思考，找到转变问题核心的关键
 */
public class LT670_MaxSwap {

	public int maximumSwap(int num) {
		char[] A = Integer.toString(num).toCharArray();
		int[] last = new int[10];
		for (int i = 0; i < A.length; i++) {
			last[A[i] - '0'] = i;
		}

		for (int i = 0; i < A.length; i++) {
			for (int d = 9; d > A[i] - '0'; d--) {
				if (last[d] > i) {
					char tmp = A[i];
					A[i] = A[last[d]];
					A[last[d]] = tmp;
					return Integer.valueOf(new String(A));
				}
			}
		}
		return num;
	}

}
