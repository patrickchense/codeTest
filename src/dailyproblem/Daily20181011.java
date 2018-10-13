package dailyproblem;
/*
This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.


 */
public class Daily20181011 {

    public static void main(String[] args) {
        String num = "111";
        System.out.println(decode(num));
        num = "1092842";
        System.out.println(decode(num));
        num = "10928428";
        System.out.println(decode(num));
        num = "10928426";
        System.out.println(decode(num));
        num = "111118";
        System.out.println(decode(num));
    }

    /*
        d[i] = d[i-1] + 1, + 1 (str[i-1] == 1 or (str[i-1] == 2 && str[i] <= 6))
     */
    public static int decode(String num) {
        int[] counts = new int[2];
        counts[0] = 1;
        counts[1] = 0;
        char[] arrays = num.toCharArray();
        for (int i = 1; i < arrays.length; i++) {
            counts[1] = counts[0] + (arrays[i-1] == '1' || (arrays[i-1] == '2' && arrays[i] <= 6) ? 1 : 0);
            counts[0] = counts[1];
        }
        return counts[1];
    }
}
