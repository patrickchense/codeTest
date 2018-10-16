package GoldmanSachs;

/*
https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.
Examples:

Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"

Input: digits[] = "1234"
Output: 3
// The possible decodings are "ABCD", "LCD", "AWD"

solution:
1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count.
2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.

@dp
@recursion

 */
public class DigitDecode {

    // Given a digit sequence of length n,
// returns count of possible decodings by
// replacing 1 with A, 2 woth B, ... 26 with Z
    static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        char digits[] = {'1', '2', '3', '4'};
        int n = digits.length;
        System.out.printf("Count is %d", countDecoding(digits, n));
    }
}
