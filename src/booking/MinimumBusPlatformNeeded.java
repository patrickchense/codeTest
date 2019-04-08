package booking;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

We can solve the above problem in O(nLogn) time. The idea is to consider all events in sorted order.
Once we have all events in sorted order, we can trace the number of trains at any time keeping track of trains that have arrived, but not departed.

@dp
@classic
@review

https://www.geeksforgeeks.org/minimum-number-of-changes-required-to-make-the-given-array-an-ap/
https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
https://www.geeksforgeeks.org/minimum-number-of-segments-required-such-that-each-segment-has-distinct-elements/
https://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
https://www.geeksforgeeks.org/minimum-number-of-towers-required-such-that-every-house-is-in-the-range-of-at-least-one-tower/
https://www.geeksforgeeks.org/minimum-total-cost-incurred-to-reach-the-last-station/
https://www.geeksforgeeks.org/find-the-minimum-number-of-operations-required-to-make-all-array-elements-equal/
https://www.geeksforgeeks.org/minimum-number-of-given-operations-required-to-convert-a-permutation-into-an-identity-permutation/


 */
public class MinimumBusPlatformNeeded {

    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j])
            {
                plat_needed++;
                i++;

                // Update result if needed
                if (plat_needed > result)
                    result = plat_needed;
            }

            // Else decrement count of platforms needed
            else
            {
                plat_needed--;
                j++;
            }
        }

        return result;
    }

    // Driver program to test methods of graph class
    public static void main(String[] args)
    {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    } }
