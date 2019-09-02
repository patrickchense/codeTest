package leetcode.arr;

/*
https://leetcode.com/problems/friends-of-appropriate-ages/
Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output:
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

@array
@optimize

占位法，数据归纳法
把大的数组，通过相同值组合，来处理
两个问题，
多个同年龄的
不同年龄的
 */
public class LT825_FriendAges {

	public int numFriendRequests(int[] ages)
	{
		int[] age = new int[121];
		for (int a : ages)
		{
			age[a]++;
		}

		int total = 0;
		for (int i = age.length - 1; i > 0; --i)
		{
			if (age[i] != 0)
			{
				int count = 0;
				if (age[i] != 1)
				{
					if (request(i, i))
					{
						count += age[i] - 1;
					}
				}

				for (int j = i - 1; j > 0; --j)
				{
					if (age[j] != 0)
					{
						if (request(i, j))
						{
							count += age[j];
						}
						else break;
					}
				}

				total += age[i] * count;
			}
		}

		return total;

	}

	boolean request(int a, int b)
	{
		if (b > a) return false;
		if (1.0 * b <= 0.5 * a + 7) return false;

		return true;
	}
}
