package uber;

import leetcode.arr.Interval;

import java.util.*;

/*
Given two lists of disjoint intervals, return their overlaps.

1: [(5, 10), (16, 20), (50, 60)]
2: [(3, 7), (9, 58)]
=> [(5, 7), (9, 10), (16, 20), (50, 58)]

@phone

@solved

 */
public class IntervalIntersection {

	public static void main(String[] args) {
		overlaps(Arrays.asList(new int[]{5, 10}, new int[]{16,20}, new int[]{50,60}), Arrays.asList(new int[]{3,7}, new int[]{9, 58})).stream().forEach(i ->System.out.println(Arrays.toString(i)));
		overlaps(Arrays.asList(new int[]{1,3}, new int[]{5, 10}, new int[]{16,20}, new int[]{50,60}), Arrays.asList(new int[]{3,7}, new int[]{9, 58})).stream().forEach(i ->System.out.println(Arrays.toString(i)));
		overlaps(Arrays.asList(new int[]{1,3}, new int[]{5, 10}, new int[]{16,20}, new int[]{50,60}), Arrays.asList(new int[]{3,7}, new int[]{9, 58}, new int[]{61, 99})).stream().forEach(i ->System.out.println(Arrays.toString(i)));
		overlaps(Arrays.asList(new int[]{1,3}, new int[]{5, 10}, new int[]{16,20}, new int[]{50,60}), Arrays.asList(new int[]{3,7}, new int[]{9, 13}, new int[]{61, 99})).stream().forEach(i ->System.out.println(Arrays.toString(i)));
	}


	public static List<int[]> overlaps(List<int[]> list1, List<int[]> list2) {
		List<int[]> result = new ArrayList<>();
		Collections.sort(list1, (i1, i2) -> {
			return i1[0] < i2[0] ? -1 : (i1[0] > i2[0] ? 1 : (i1[1] < i2[1] ? -1 : (i1[1] > i2[1] ? 1 : 0)));
		});
		Collections.sort(list2, (i1, i2) -> {
			return i1[0] < i2[0] ? -1 : (i1[0] > i2[0] ? 1 : (i1[1] < i2[1] ? -1 : (i1[1] > i2[1] ? 1 : 0)));
		});

		int i = 0, j = 0;
		int[] res = new int[2];
		while (i < list1.size() && j < list2.size()) {
			int[] t = list1.get(i);
			int[] p = list2.get(j);
			if (t[0] <= p[0] && p[0] <= t[1]) {
				res[0] = p[0];
				if (p[1] <= t[1]) {
					res[1] = p[1];
					j++;
				}
				else {
					res[1] = t[1];
					i++;
				}
				result.add(res);
				res = new int[2];
			}
			else if (t[0] >= p[0] && t[0] <= p[1]) {
				res[0] = t[0];
				if (t[1] <= p[1]) {
					res[1] = t[1];
					i++;
				}
				else {
					res[1] = p[1];
					j++;
				}
				result.add(res);
				res = new int[2];
			}
			else {
				if (p[1] < t[0]) j++;
				else i++;
				continue;
			}


		}

		return result;
	}


	public static void mergeIntervals(Interval arr[]) {
		// Test if the given set has at least one interval
		if (arr.length <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> stack = new Stack<>();

		// sort the intervals in increasing order of start time
		Arrays.sort(arr, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		// push the first interval to stack
		stack.push(arr[0]);

		// Start from the next interval and merge if necessary
		for (int i = 1; i < arr.length; i++) {
			// get interval from stack top
			Interval top = stack.peek();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.end < arr[i].start)
				stack.push(arr[i]);

				// Otherwise update the ending time of top if ending of current
				// interval is more
			else if (top.end < arr[i].end) {
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}
		}

		// Print contents of stack
		System.out.print("The Merged Intervals are: ");
		while (!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.print("[" + t.start + "," + t.end + "] ");
		}
	}
}
