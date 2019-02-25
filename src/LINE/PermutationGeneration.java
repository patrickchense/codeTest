package LINE;

import java.util.ArrayList;
import java.util.List;

/*
https://www.cnblogs.com/dragonpig/archive/2010/01/21/1653680.html

如何在每下一次的生成排列做到，不用额外空间，最好是原地的，并且修改量要小，否则就是一个大常数乘以恐怖的N！。
主要的算法（其实都很古老了，最早可以追溯到1650s）
包括1. backtracking 2. Plain changes 3.字典序列（lexicographic genenration）4. Index table 5.Heap's algorithm

LINE first interview ask questions about this

https://leetcode.com/problems/permutation-sequence/
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"


 */
public class PermutationGeneration {

    public static void main(String[] args) {
        System.out.println(permutation(3, 3));
        System.out.println(permutation(4, 9));


    }

    // ordered, count
    /*
        how many combines?
            mod *= i;
        how many combines for current number?
            i == 0
                mod /= n; (n--)
            what's first number ?
                k/mod = cur_inx, first = nums.get(cur_inx)
                after k%=mod, nums.remove(cur_inx)
            second number?
                except number n--, how many changes?
                    mod/=(n--) == 2
                    cur = k/mod == 3/2 == 1
                    k%=mod == 1
            逻辑在于，每次计算可能的组合次数，然后 k/mod 就是当前的数在数组的位置，

     */
    // O(n), O(n)
    static String permutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        String ans=new String();
        int mod=1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            mod*=i;
        }
        k--;
        for(int i=n; i>0; i--){
            mod=mod/i;
            int cur=k/mod;
            k%=mod;
            ans+=nums.get(cur);
            nums.remove(cur);
        }
        return ans;
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] visiteds = new boolean[n];
        int left = n, sum = 1, p = 1;
        while(p++ < left-1) sum*=p;
        while(true){
            int idx = (k-1)/sum;
            for (int i = 0, j = -1; i < n; i++){
                if (!visiteds[i] && idx == ++j) {
                    visiteds[i] = true;
                    sb.append(i+1);
                    if (sb.length() == n) return sb.toString();
                    k-=idx*sum;
                    sum/=--left;
                    break;
                }
            }
        }
    }

    /*
    https://leetcode.com/problems/letter-case-permutation/
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
     */

    public static List<String> letterPermutation(String s) {

    }


    // https://leetcode.com/problems/next-permutation/

    // https://leetcode.com/problems/permutations/

    // https://leetcode.com/problems/permutations-ii/
}
