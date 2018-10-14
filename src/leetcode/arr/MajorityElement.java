package leetcode.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
leetcode 229
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

@math 摩斯投票
 */
public class MajorityElement {

    /*
    思路：摩尔投票升级版，超过n/3的数最多只能有两个；
    先选出两个候选人A,B,遍历数组，如果投A（等于A），则A的票数++;如果投B，B的票数++；
    如果A,B都不投（即与A，B都不相等）,那么检查此时是否AB中候选人的票数是否为0，如果为0,则成为新的候选人；
    如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均--；
    遍历结束后选出两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数
     */
    public List<Integer> majorityElement(int[] nums) {
        if (nums==null||nums.length==0){
            return Collections.emptyList();
        }

        //初始化，定义两个候选人以及对应的票数
        int candidateA=nums[0];
        int candidateB=nums[0];
        int countA=0;
        int countB=0;

        // 遍历数组
        for (int num:nums){
            if (num==candidateA){ //投A
                countA++;
                continue;
            }

            if (num==candidateB){// 投B
                countB++;
                continue;
            }
            //此时A,B都不投,检查是否有票数为0情况，如果为0，则更新候选人
            if (countA==0){
                candidateA=num;
                countA++;
                continue;
            }

            if (countB==0){
                candidateB=num;
                countB++;
                continue;
            }

            //此时两个候选人的票数都大于1，且当前选名不投AB，那么A,B对应的票数都要--;
            //同时当C出现的次数多于AB的时候，C自然提升为AB之一
            countA--;
            countB--;
        }

        // 上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA=0;
        countB=0;

        for (int num:nums){
            if (num==candidateA){
                countA++;
            }else if (num==candidateB){
                countB++;
            }
        }

        List<Integer> resultList=new ArrayList<>();

        if (countA>nums.length/3){
            resultList.add(candidateA);
        }

        if (countB>nums.length/3){
            resultList.add(candidateB);
        }

        return resultList;
    }
}
