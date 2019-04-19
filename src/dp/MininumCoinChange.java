package dp;

/*
https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-coin-change-problem/

@dp

Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn . Write a program to find out minimum numbers of coins required to make the change for the amount ‘A’.
Amount: 5

Coins [] = 1, 2, 3.

No of ways to make the change are : { 1,1,1,1,1} , {1,1,1,2}, {2,2,1},{1,1,3} and {3,2}.

So as we can see minimum number of coins required are 2 ( 3+2=5}.

公式？
这是squar的简单版，一个数组保存结果， 关键在
外循环 amount
内循环 for (int j = 0; j < coins.length; j++) {
    然后条件是  coins[j] <= amt

 公式： coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1,coinReq[amt]) ;
 */
public class MininumCoinChange {

    public static void main(String[] args) {
        System.out.println(miniumnCoin(new int[]{1, 2, 3}, 20));
    }

    public static int miniumnCoin(int[] coins, int amount) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount+1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1,coinReq[amt]) ;
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];
    }
}
