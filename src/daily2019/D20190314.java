package daily2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/*
Given a 32-bit integer, return the number with its bits reversed.

For example, given the binary number 1111 0000 1111 0000 1111 0000 1111 0000, return 0000 1111 0000 1111 0000 1111 0000 1111.

@Facebook
@solved
@review
@bitop
bit 操作
https://www.geeksforgeeks.org/reverse-actual-bits-given-number/
https://www.geeksforgeeks.org/reverse-bits-using-lookup-table-in-o1-time/
https://www.geeksforgeeks.org/invert-actual-bits-number/
https://www.geeksforgeeks.org/check-actual-binary-representation-number-palindrome/
https://www.geeksforgeeks.org/set-all-even-bits-of-a-number/
https://www.geeksforgeeks.org/set-odd-bits-number/
https://www.geeksforgeeks.org/number-set-bits-n/



 */
public class D20190314 {

    public static void main(String[] args) {
        String s = "11110000111100001111000011110000";
        System.out.println(bitReverse(s));
        System.out.println(reverseBits(11));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(bitReverse(Integer.toBinaryString(11)));
        System.out.println(reverseBits(10));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(bitReverse(Integer.toBinaryString(5)));
    }

    public static String bitReverse(String s) {
        String t = String.join("", Collections.nCopies(s.length(), "1"));
        int[] ts = new int[s.length()];
        for (int i = 0; i < t.length(); i++) {
            ts[i] = t.charAt(i) ^ s.charAt(i);
        }
        return Arrays.stream(ts).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    // 直接int 不是字符串怎么办？， 可以Integer.toBinaryString(), 也可以直接
    // 通过一个res, 一位位的^, 同时原始n >> 右移
    //  O(num), where num is the number of bits in the binary representation of n
    public static int reverseBits(int n)
    {
        int rev = 0;
        // traversing bits of 'n'
        // from the right
        while (n > 0)
        {
            // bitwise left shift
            // 'rev' by 1
            rev <<= 1;

            // if current bit is '1' ， '0' 不用处理
            if ((int)(n & 1) == 1)
                rev ^= 1;

            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
    }
}
