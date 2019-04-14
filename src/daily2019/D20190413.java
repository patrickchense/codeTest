package daily2019;

/*
You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to advance to the end.
 You can advance at most, the number of steps that you're currently on. Determine whether you can get to the end of the array.

For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
@Google
@medium
@array
@10min
@dp
@review
@solved,  用一个dp 公式  O(n) space, O(n * k) time 不是很好
https://www.programcreek.com/2014/03/leetcode-jump-game-java/


related:
https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
https://www.geeksforgeeks.org/check-given-power-enough-reach-end-array-please-review/
 */
public class D20190413 {

    public static void main(String[] args) {
        System.out.println(reachable(new int[]{1, 3, 1, 2, 0, 1}));
        System.out.println(canJump(new int[]{1, 3, 1, 2, 0, 1}));
        System.out.println(reachable(new int[]{1, 2, 1, 0, 0}));
        System.out.println(canJump(new int[]{1, 2, 1, 0, 0}));
    }

    public static boolean reachable(int[] arr) {
        boolean[] reacables = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (reacables[i] && arr[i] >= (arr.length - 1 -i)) return true;
            if (arr[i] > 0) {
                int t = arr[i];
                int ti = i;
                while(t > 0) {
                    reacables[ti] = true;
                    t--;
                    ti++;
                }
            }
        }
        return false;
    }

    // 这个方法简单，计算最大保留步数
    public static boolean canJump(int[] A) {
        if(A.length <= 1)
            return true;

        int max = A[0]; //max stands for the largest index that can be reached.

        for(int i=0; i<A.length; i++){
            //if not enough to go to next
            if(max <= i && A[i] == 0)
                return false;

            //update max
            if(i + A[i] > max){
                max = i + A[i];
            }

            //max is enough to reach the end
            if(max >= A.length-1)
                return true;
        }

        return false;
    }
}
