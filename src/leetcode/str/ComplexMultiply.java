package leetcode.str;
/*
leetcode 537
https://leetcode.com/problems/complex-number-multiplication/description/
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

 */
public class ComplexMultiply {

    /*
        use normal way to decode a/b
     */
    public String complexNumberMultiply(String a, String b) {
        int a_int = 0;
        int a_i = 0;
        int b_int = 0;
        int b_i =0;

        int plus_index = a.indexOf("+");
        a_int = Integer.valueOf(a.substring(0, plus_index));
        a_i = Integer.valueOf(a.substring(plus_index+1, a.indexOf("i")));

        plus_index = b.indexOf("+");
        b_int = Integer.valueOf(b.substring(0, plus_index));
        b_i = Integer.valueOf(b.substring( plus_index+1, b.indexOf("i") ));

        int res = a_int * b_int - a_i * b_i;
        int res_i = a_int * b_i + b_int * a_i;
        return String.valueOf(res) + "+" + String.valueOf(res_i) + "i";
    }

    /*
    use split to decode, more easier, O(1) O(1)
     */
    public String complexNumberMultiply2(String a, String b) {

        String x[] = a.split("\\+|i");  // *** about the regex use in java
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
    }
}
