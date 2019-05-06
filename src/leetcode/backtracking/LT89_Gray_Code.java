package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/gray-code/

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].


@medium
@backtracing

@solved


 */
public class LT89_Gray_Code {

    // 自己的解法是backtracking的，往list加数字，然后转int
    public List<Integer> grayCode(int n) {
        if (n ==0 ) return Arrays.asList(1);
        List<Integer> res = new ArrayList<>();
        List<String> tmp = backtracking(n);
        for (int i = 0; i < tmp.size(); i++) {
            res.add(Integer.parseInt(tmp.get(i),2));
        }
        return res;
    }

    List<String> backtracking(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1");
        }
        List<String> sub = backtracking(--n);
        List<String> res = new ArrayList<>(sub.size());
        for (int i = 0; i < sub.size(); i++) {
            res.add("0" + sub.get(i));

        }
        for (int i = 0; i < sub.size(); i++) {
            res.add("1" + sub.get(i));

        }
        return res;
    }

    // 有个数学的解法：
    public List<Integer> grayCode2(int n) {
        int len = (int) Math.pow(2, n);
        List<Integer> ans = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
