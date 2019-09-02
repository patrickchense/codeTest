package leetcode.arr;

/*
https://leetcode.com/problems/circular-array-loop/
You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.



Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.


@dfs
@review

 */
public class LT457_CircleArrLoop {

	/*
	自己写的时候，几个问题没解决？
	1. 怎么判断已经过了这个点，不可能circle了  利用visted[boolean] 数组
	为什么需要2个boolean 数组， 一个记录全局的visited，一个记录临时的判断循环
	O(n) space
	 */
	public boolean circularArrayLoop(int[] nums) {
		int n = nums.length;
		boolean visited[] = new boolean[n];
		boolean instack[] = new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				if(dfs(i,nums,visited,instack)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(int i,int nums[],boolean visited[],boolean instack[]) {
		visited[i] = true;
		instack[i] = true;
		int next = nextIdx(i,nums);
		if(instack[next] && (nums[next]>0 && nums[i]>0 || nums[next]<0 && nums[i]<0) && next!=i) {
			return true;
		}
		boolean ans = false;
		if(!visited[next] && (nums[next]>0 && nums[i]>0 || nums[next]<0 && nums[i]<0)) {
			ans = dfs(next, nums, visited, instack);
		}
		instack[i] = false;
		return ans;
	}

	private int nextIdx(int i,int nums[]) {
		int next = nums[i];
		int rem = next%nums.length;
		int nextIdx = rem+i;
		if(nextIdx<0) {
			nextIdx = nums.length+nextIdx;
		} else {
			nextIdx = nextIdx%nums.length;
		}
		return nextIdx;
	}
}
