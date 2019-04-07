package dailyproblem;

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

@Google
@array
@bitop
@kth
@review
@classic
@answered

不会
https://www.geeksforgeeks.org/find-the-element-that-appears-once/

Run a loop for all elements in array. At the end of every iteration, maintain following two values.

ones: The bits that have appeared 1st time or 4th time or 7th time .. etc.

twos: The bits that have appeared 2nd time or 5th time or 8th time .. etc.

Finally, we return the value of ‘ones’

How to maintain the values of ‘ones’ and ‘twos’?
‘ones’ and ‘twos’ are initialized as 0. For every new element in array, find out the common set bits in the new element and previous value of ‘ones’.
These common set bits are actually the bits that should be added to ‘twos’. So do bitwise OR of the common set bits with ‘twos’. ‘twos’ also gets some extra bits that appear third time.
These extra bits are removed later.
Update ‘ones’ by doing XOR of new element with previous value of ‘ones’. There may be some bits which appear 3rd time. These extra bits are also removed later.

Both ‘ones’ and ‘twos’ contain those extra bits which appear 3rd time. Remove these extra bits by finding out common set bits in ‘ones’ and ‘twos’.

经典的bit 操作！！！

@hard
1,4,7 都通过 one 解决了
2，5，8，都通过 two 解决
但是3，6，9 怎么办？
 */
public class Daily20181113 {

    public static void main(String[] args) {
        System.out.println(getSingle(new int[]{6, 1, 3, 3, 3, 6, 6}, 7));
        System.out.println(getSingle(new int[]{6, 1, 3, 3, 3, 6, 6, 6,6,6, 3,3,3}, 13));
    }

    // 这里算法，只支持3，6，9， 不支持其他的
    static int getSingle(int arr[], int n)
    {
        int ones = 0, twos = 0;
        int common_bit_mask;

        for(int i=0; i<n; i++ )
        {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & arr[i]);

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ arr[i];

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);  // 3，6，9处理，通过 one & two 与，然后取反，然后one,two 与取反值 与之后，就去掉了

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }
}
