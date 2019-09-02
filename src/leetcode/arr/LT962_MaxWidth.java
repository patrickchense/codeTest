package leetcode.arr;

/*
https://leetcode.com/problems/maximum-width-ramp/

Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.



Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation:
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation:
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.

@array
@binarysearch
@sort
@optimize
@review
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT962_MaxWidth {

	public int maxWidthRamp(int[] A) {
		int N = A.length;

		int ans = 0;
		List<Point> candidates = new ArrayList();
		candidates.add(new Point(A[N - 1], N - 1));

		// candidates: i's decreasing, by increasing value of A[i]
		for (int i = N - 2; i >= 0; --i) {
			// Find largest j in candidates with A[j] >= A[i]
			int lo = 0, hi = candidates.size();
			while (lo < hi) {
				int mi = lo + (hi - lo) / 2;
				if (candidates.get(mi).x < A[i])
					lo = mi + 1;
				else
					hi = mi;
			}

			if (lo < candidates.size()) {
				int j = candidates.get(lo).y;
				ans = Math.max(ans, j - i);
			} else {
				candidates.add(new Point(A[i], i));
			}
		}
		return ans;
	}

	public int maxWidthRamp1(int[] A) {
		int N = A.length;
		Integer[] B = new Integer[N];
		for (int i = 0; i < N; ++i)
			B[i] = i;

		Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

		int ans = 0;
		int m = N;
		for (int i : B) {
			ans = Math.max(ans, i - m);
			m = Math.min(m, i);
		}

		return ans;
	}


	// best, fast
	public int maxWidthRamp2(int[] A) {
		int n = A.length;
		if (n == 0) {
			return 0;
		}

		int[] leftCandidate = new int[n]; // all "possible" left indexes
		int[] rightCandidate = new int[n]; // all "possible" right indexes


		int currentLeft = 50_001; // all elements in the range [0,50_000]. We want to ensure considering index = 0
		int counter1 = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] < currentLeft) {
				leftCandidate[counter1] = i;
				currentLeft = A[i];
				counter1++;
			}
		}
		int n1 = counter1;


		int counter2 = 0;
		int currentRight = -1; // all elements in the range [0,50_000]. We want to ensure considering index = n-1.
		for (int i = n - 1; i >= 0; i--) {
			if (A[i] > currentRight) {
				rightCandidate[counter2] = i;
				currentRight = A[i];
				counter2++;
			}
		}
		int n2 = counter2;

		int maxSolution = 0;
		int j = n2 - 1;

		for (int i = 0; i < n1; i++) {
			while (j >= 0 && A[rightCandidate[j]] >= A[leftCandidate[i]]) {
				j--; // try to advance j
			}
			j++; // we advanced j one step one step "too much".
			maxSolution = Math.max(maxSolution, rightCandidate[j] - leftCandidate[i]);
		}

		return maxSolution;
	}
}
