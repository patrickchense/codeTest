package daily2019;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of numbers representing the stock prices of a company in chronological order and an integer k,
return the maximum profit you can make from k buys and sells. You must buy the stock before you can sell it, and you must sell the stock before you can buy it again.

For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.

@Facebook
@solved
@logical

解决问题的关键在于计算stock price，次数不重要

 */
public class D20190211 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 0, 1};
        System.out.println(maxProfitK(arr, 2));
    }

    /*
    不管次数
    a[0] < a[1] a[1] < a[2] ... until  a[i] > a[i+1] a[i] - a[0] == profit
    do it again
    sum up profit

    存起来，排序找到最大k次profit

    O(n) O(k) space
     */
    public static int maxProfitK(int[] arr, int k) {
        List<Integer> profits = new ArrayList<>();
        int buy = -1;
        for (int i = 0; i < arr.length; i++) {
            if (buy >= 0) {
                if (arr[i] <= buy) {
                    buy = arr[i];
                    continue;
                }
                else {
                    if (i != arr.length -1 && arr[i] < arr[i+1]) continue;
                    profits.add(arr[i] - buy);
                    buy = -1;
                }
            } else {
                buy = arr[i];
            }
        }
        int max = profits.get(0);
        int sec = profits.get(1);
        if (sec > max) {
            int t = max;
            max = sec;
            sec = t;
        }
        for (int i = 2; i < profits.size(); i++) {
            if (i >= max) {
                sec = max;
                max = i;
            } else if (i > sec && i < max) {
                sec = i;
            }
        }
        return sec + max;
    }

}
