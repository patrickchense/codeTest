package dailyproblem;

import java.util.Random;

/*
Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

@facebook

solution:
https://www.dailycodingproblem.com/blog/how-to-pick-a-random-element-from-an-infinite-stream/
https://galayko.rocks/posts/probability/
https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/

@source
https://www.geeksforgeeks.org/reservoir-sampling/

For i = 0, we would’ve picked uniformly from [0, 0].
For i > 0, before the loop began, any element K in [0, i - 1] had 1 / i chance
of being chosen as the random element. We want K to have 1 / (i + 1) chance
of being chosen after the iteration. This is the case since the chance of having
being chosen already but not getting swapped with the ith element is
1 / i * (1 - (1 / (i + 1))) which is 1 / i * i / (i + 1) or 1 / (i + 1)


 */
public class Daily20181019 {

    static int res = 0;    // The resultant random number
    static int count = 0;  //Count of numbers visited so far in stream

    //A method to randomly select a item from stream[0], stream[1], .. stream[i-1]
    static int selectRandom(int x) {
        count++; // increment count of numbers seen so far

        // If this is the first element from stream, return it
        if (count == 1)
            res = x;
        else {
            // Generate a random number from 0 to count - 1
            Random r = new Random();
            int i = r.nextInt(count);

            // Replace the prev random number with new number with 1/count probability
            if (i == count - 1)
                res = x;
        }
        return res;
    }

    // Driver program to test above function.
    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 20,21,33,2,3,55,7,8,5,10,23,6,231};
        int n = stream.length;
        for (int i = 0; i < n; i++)
            System.out.println("Random number from first " + (i + 1) +
                    " numbers is " + selectRandom(stream[i]));
    }
}
