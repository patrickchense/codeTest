package leetcode.arr;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1

@answered
@array
@dp
@review


 */
public class LT518_CoinChange2 {

    public int change(int amount, int[] coins) {
        if(amount <=0) return 1;
        if(amount>0 && coins.length<1) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int j = 0; j < coins.length; j++ ) {//iterate through all coin denoms
            for(int i = 1; i < dp.length; i++) {//iterate through all amounts till amount
                if(i - coins[j] >=0) {//can add coin to another amount to sum to dp
                    int subamount = i - coins[j];//can reach this subamount
                    dp[i] += dp[subamount];//add ways to reach this subamount
                }
            }
        }
        return dp[dp.length-1];//return last element in dp
    }

    // faster,
    public int change2(int amount, int[] coins) {
        if(coins.length < 1){
            return amount == 0 ? 1 : 0;
        }
        Arrays.sort(coins);
        if(amount < coins[0]){
            return 1;
        }
        int[] dp = new int[amount+1];
        for(int i=0; i<coins.length; i++){
            for(int j = coins[i]; j<=amount; j++){
                if(j == coins[i]){
                    dp[j] += dp[j - coins[i]] + 1;
                }else{
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
