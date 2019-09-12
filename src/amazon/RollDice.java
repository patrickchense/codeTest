package amazon;

import java.util.HashMap;
import java.util.Map;

/*
A six-sided die is a small cube with a different number of pips on each face (side), ranging from 1 to 6.
On any two opposite side of the cube, the number of pips adds up to 7; that is, there are three pairs of opposite sides: 1 and 6, 2 and 5, and 3 and 4.
There are N dice lying on a table, each showing the pips on its top face. In one move, you can take one die and rotate it to an adjacent face.
For example, you can rotate a die that shows 1 s that it shows 2, 3, 4 or 5. However, it cannot show 6 in a single move,
because the faces with one pip and six pips visible are opposite sides rather than adjacent.
You want to show the same number of pips on the top face of all N dice. Given that each of the dice can be moved multiple times,
count the minimum number of moves needed to get equal faces.

Write a function that, given an array A consisting of N integers describing the number of pips (from 1 to 6) shown on each die's top face,
returns the minimum number of moves necessary for each die show the same number of pips.

Example 1:

Input: A = [1, 2, 3]
Output: 2
Explanation: You can pick the first two dice and rotate each of them in one move so that they all show three pips on the top face.
Notice that you can also pick any other pair of dice in this case.
Example 2:

Input: A = [1, 1, 6]
Output: 2
Explanation: The only optimal answer is to rotate the last die so that it shows one pip. It is necessary to use two rotations to achieve this.
Example 3:

Input: A = [1, 6, 2, 3]
Output: 3
Explanation: For instance, you can make all dice show 2: just rotate each die which is not showing 2.
Notice that for each die you can do this in one move.
A ssume that:
• N is an integer within the range [1..100];
• each element of the array A is an integer within the range [1..6].

@solved
 */
public class RollDice {

	public static void main(String[] args) {
		System.out.println(minRoll(new int[]{1,3,2}));
		System.out.println(minRoll(new int[]{1,1, 6}));
		System.out.println(minRoll(new int[]{1, 6, 2, 3}));
	}

	// less opsite as possible, as more same as possible
	public static int minRoll(int[] pips) {
		Map<Integer, Integer> cnt = new HashMap<>(6);
		int max = 0;
		int max_pip = 1;
		for (int i : pips) {
			cnt.put(i, cnt.getOrDefault(i, 0) + 1);

			cnt.put(7 - i, cnt.getOrDefault(7 - i, 0) - 1);
		}

		for (int i : cnt.keySet()) {
			if (cnt.get(i) > max) {
				max = cnt.get(i);
				max_pip = i;
			}
		}

		int res = 0;
		for (int i : pips) {
			if (i != max_pip) {
				if (i == 7 - max_pip) res += 2;
				else res += 1;
			}
		}
		return res;
	}

	public int rollDice(int[] A){
		int len = A.length;
		if(len <= 1) return 0;
		int[] steps = new int[7];
		for(int i = 0; i < len; ++i){
			int surface = A[i];
			for(int j = 1; j <= 6; ++j){
				if(A[i] + j == 7)
					steps[j] += 2;
				else if(A[i] != j)
					++steps[j];
			}
		}
		int min = steps[1];
		for(int i = 2; i <= 6; ++i) min = Math.min(min, steps[i]);
		return min;
	}

}
