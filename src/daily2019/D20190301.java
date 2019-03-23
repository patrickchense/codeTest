package daily2019;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*
Gray code is a binary code where each successive value differ in only one bit, as well as when wrapping around.
Gray code is common in hardware so that we don't see temporary spurious values during transitions.

Given a number of bits n, generate a possible gray code for it.

For example, for n = 2, one gray code would be [00, 01, 11, 10].
n=3, 000, 001, 010, 011, 100, 101, 110, 111
n=4, 16个
@Apple

@solved
@review

所有的bit组合n位数
1. Integer 怎么转binary, java的实现要看懂, Integer好多方法不懂, numberOfLeadingZeros 也不懂
2. leading 0 怎么解决， String format
 */
public class D20190301 {
    public static void main(String[] args) {
        ArrayUtil.printList(allBits(2));
        ArrayUtil.printList(allBits(3));
    }

    public static List<String> allBits(int n) {
        List<String> results = new ArrayList<>();
        int max = (int) Math.pow(2, n);
        for(int i = 1; i <= max; i++) {
            results.add(String.format("%" + n + "s", toUnsignedString0(i, 1)).replace(' ', '0'));
        }
        return results;
    }

    private static String toUnsignedString0(int val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];

        formatUnsignedInt(val, shift, buf, 0, chars);

        // Use special constructor which takes over "buf".
        return new String(buf);
    }

    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len) {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = digits[val & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
}
