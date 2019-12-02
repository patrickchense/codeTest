package daily2019;

/*
Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i. Return null if there is no such index.

For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2. Even though arr[3] == 3, we return 2 since it's the lowest index.

@Amazon
@hard
@solved
@optimized

 */
public class D20191129 {

	public static void main(String[] args) {
		System.out.println(findLowestIndexEqVal(new int[]{-5,-3,2,3}));
		System.out.println(findLowestIndexEqVal2(new int[]{-5,-3,2,3}, 0, 3));
	}

	// O(n)
	private static Integer findLowestIndexEqVal(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			if (i < ints[i]) return null;
			if (i == ints[i]) return i;
		}
		return null;
	}

	// Optimize？ binary？
	private static Integer findLowestIndexEqVal2(int[] ints, int start, int end) {
		if (start >= end) return null;
		int mid = ((end - start) >> 1) + start;
		Integer low = findLowestIndexEqVal2(ints, start, mid - 1);
		if (low != null) return low;
		if (ints[mid] == mid) {
			 return mid;
		}
		Integer hig = findLowestIndexEqVal2(ints, mid + 1, end);
		return hig;
	}
}
