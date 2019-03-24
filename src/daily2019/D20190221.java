package daily2019;

import java.util.Arrays;
import java.util.List;

/*
Given an arry of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the arry [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?

@Facebook
@arry
@answered
@bitop
@review

https://algorithms.tutorialhorizon.com/find-two-non-repeating-numbers-in-an-arry-in-on-time-and-o1-space/ XOR解法

https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

https://www.geeksforgeeks.org/given-an-arry-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/

bit 操作是关键，找到最右侧第一个1， x & ~(x-1) 就能得到最右侧第一个1
另一个关键在于分组， 根据最右侧第一个1，分组，& 1 == 0的一组， & 1 == 1 的一组，这两组的XOR结果就是

D20190314.java

记录到bit.txt
 */
public class D20190221 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 10, 2, 6, 10};
        System.out.println(Arrays.toString(findTwoUnqiueElement(arr)));
    }

    // need O(n), O(1), 关键在于，怎么表示数据已存在，在当前的arry上直接修改?  arr[arr[i]] 类似的做法, 这里的问题在于number不是0..n-1范围
    // 这道题的关键在于unique的数字是2个, 怎么理解？ XOR方式

    /*
    traverse the list for i= 0 to n-1 elements
{
  check for sign of A[abs(A[i])] ;
  if positive then
     make it negative by   A[abs(A[i])]=-A[abs(A[i])];
  else  // i.e., A[abs(A[i])] is negative
     this   element (ith element of list) is a repetition
}

Let’s say non-repeating elements are X, Y.
A XOR A = 0
XOR all the elements of array. This will cancel all the repeated elements.
Result will be X XOR Y, since only X and Y are not repeating.
1 XOR 1 =  0 and 1 XOR 0 = 1 with this logic in the result of X XOR Y if any kth bit is set to 1  implies either kth bit is 1 either in X or in Y not in both.
Use the above step to divide all the ele­ments in array into 2 groups, one group which has the ele­ments for which the kth bit is set to 1 and sec­ond group which has the ele­ments for which the kth bit is 0.
Let’s have that kth bit as right most set bit (Read how to find right most set bit)
Now we can claim that these two groups are respon­si­ble to pro­duce X and Y.
Group –1: XOR all the ele­ments whose kth bit is 1 will pro­duce either X or Y.
Group –2: XOR all the ele­ments whose kth bit is 0 will pro­duce either X or Y.
     */
    public static int[] findTwoUnqiueElement(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            xor ^= arr[i];
        }
        System.out.println(Integer.toBinaryString(xor));
        //get the right most set bit
        int right_most_set_bit = xor & ~ (xor -1);
        System.out.println(Integer.toBinaryString(xor-1));
        System.out.println(Integer.toBinaryString(~(xor-1)));
        System.out.println(Integer.toBinaryString(right_most_set_bit));

        //divide the arry elements into 2 groups
        int a=0,b=0;
        for (int i = 0; i <arr.length ; i++) {
            int x = arr[i];
            if((x & right_most_set_bit)!=0)
                a ^= x;
            else
                b ^= x;
        }
        return new int[]{a, b};
    }
}
