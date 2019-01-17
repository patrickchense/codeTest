package dailyproblem;

/*
Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

@ContextLogic

@solved
 */
public class Daily20181231 {


    public static void main(String[] args) {
        System.out.println(divide(101, 2));
        System.out.println(divide(101, 3));
    }

    // O(log2N)?
    public static int divide(int a, int b) {
        //assume a > b
        int limit = b*2;
        int num = 0;
        int previous = 0;
        while (limit < a) {
            previous = num;
            limit = b * num;
        }
        if (limit == a) return num;
        while (num > previous) {
            limit -= b;
            num--;
            if (limit <= a) break;
        }
        return num;
    }
}
