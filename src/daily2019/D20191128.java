package daily2019;

import java.util.Arrays;

/*
Given a list of integers L, find the maximum length of a sequence of consecutive numbers that can be formed using elements from L.

For example, given L = [5, 2, 99, 3, 4, 1, 100], return 5 as we can build a sequence [1, 2, 3, 4, 5] which has length 5.

@Facebook
@hard
@solved

 */
public class D20191128 {

	public static void main(String[] args) {
		System.out.println(consecutiveEle(new int[]{5,2,99,3,4,1,100}));
		System.out.println(consecutiveEle(new int[]{2,6,7,4,3,5,102,22,55}));
	}

	// O(nlogn）sort, how to optimize??
	private static int consecutiveEle(int[] ints) {
		Arrays.sort(ints);

		int res = -1;
		int cur = 0;
		for (int i = 1; i < ints.length; i++) {
			if (ints[i] - ints[i-1] == 1) {
				cur++;
				if (cur + 1 <= ints[i] && cur + 1 >= (ints[i] - cur)) {
					res = Math.max(cur + 1, res);
				}
			} else {
				cur = 0;
			}
		}

		return res;
	}


}
