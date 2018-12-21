package dailyproblem;

/*
Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.

@facebook
@solved
 */
public class Daily20181120 {

    // dp questions
    /*
        keep the min
     */
    public static int maxBuySellStock(int[] prices) {
        int[] earns = new int[prices.length-1];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                earns[i-1] = prices[i] - min;
            } else {
                min = prices[i];
            }
        }
        int max = 0;
        for (int i : earns) max = Math.max(i, max);
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{9, 11, 8, 5, 7, 10};
        System.out.println(maxBuySellStock(prices));
    }
}
