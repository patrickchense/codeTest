package dailyproblem;

/*
Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.

@facebook
@solved
 */
public class Daily20181228 {

    public static void main(String[] args) {
        System.out.println(bitOp(1,2, 0));
        System.out.println(bitOp(1,2, 1));
    }

    public static int bitOp(int x, int y, int b) {
        if (b << b == b) return y;
        return x;
    }

}
