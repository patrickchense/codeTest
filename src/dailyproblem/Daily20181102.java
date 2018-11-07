package dailyproblem;

/*
Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
You can assume the string to be decoded is valid.

@amazon
@solved
 */
public class Daily20181102 {

    /*
    assume all Capital
    O(n) O(1)
     */
    public static String encode(String str) {
        int count = 1;
        StringBuilder sb = new StringBuilder("");
        char[] c = str.toCharArray();
        for(int i = 1; i < c.length; i++) {
            if (c[i] != c[i-1]) {
                sb.append(count).append(c[i-1]);
                count = 1;
            }
            else {
                count++;
            }
            if (i == c.length - 1) {
                sb.append(count).append(c[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("AAAABBBCCDAA"));
        System.out.println(encode("AAAABBBCCDAAE"));
    }
}
