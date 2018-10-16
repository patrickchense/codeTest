package GoldmanSachs;

import java.util.ArrayList;

/*
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 the maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.
 If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.

related, if buy/sell at the same day, turn into
Maximum difference between two elements such that larger element appears after the smaller number
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

solution for maximum difference:
1. brute force
2. In this method, instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. So we need to keep track of 2 things:
1) Maximum difference found so far (max_diff).
2) Minimum number visited so far (min_element).

solutions for stock:
If we are allowed to buy and sell only once, then we can use following algorithm. Maximum difference between two elements. Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached.



 */
public class MaxmiumStockProfit {

    class Interval {
        int buy, sell;
    }

    /* The function assumes that there are at least two
       elements in array.
       The function returns a negative value if the array is
       sorted in decreasing order.
       Returns 0 if elements are equal  */
    //O(n) O(1)
    int maxDiff(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) {
            if (arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    // This function finds the buy sell schedule for maximum profit
    void stockBuySell(int price[], int n) {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima


            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "        " + "Sell on day : " + sol.get(j).sell);

        return;
    }

    public static void main(String args[]) {
        MaxmiumStockProfit stock = new MaxmiumStockProfit();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
    }
}
