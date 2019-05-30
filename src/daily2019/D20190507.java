package daily2019;

import java.util.HashMap;
import java.util.Map;

/*
Given a number in Roman numeral format, convert it to decimal.

The values of Roman numerals are as follows:

{
    'M': 1000,
    'D': 500,
    'C': 100,
    'L': 50,
    'X': 10,
    'V': 5,
    'I': 1
}
In addition, note that the Roman numeral system uses subtractive notation for numbers such as IV and XL.

For the input XIV, for instance, you should return 14.


@Facebook
@medium

@solved

逻辑问题
 */
public class D20190507 {

    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("XL"));
    }


    static Map<Character, Integer> maps = new HashMap<>();
    static {
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
    }


    public static int romanToInt(String str) {
        int res = 0;

        char[] cs = str.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (i != cs.length - 1) {
                if (maps.get(cs[i]) < maps.get(cs[i+1])) {
                    res -= maps.get(cs[i]);
                    continue;
                }
            }
            res += maps.get(cs[i]);
        }

        return res;
    }
}
