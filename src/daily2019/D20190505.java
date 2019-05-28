package daily2019;

/*
Given an integer n, return the length of the longest consecutive run of 1s in its binary representation.

For example, given 156, you should return 3.

@Stripe

@easy
@solved
@5min
@bitop

简单的bit 操作， & 1 == 1 意味着当前位位==1, 不停的右移即可 >>1


 */
public class D20190505 {

    public static void main(String[] args) {
        System.out.println(longestBinary1s(156));
    }

    public static int longestBinary1s(int num) {
        int res = 0;
        int cur = 0;
        while(num > 0) {
            if ((num & 1) == 1) cur++;
            else {
                res = Math.max(cur, res);
                cur = 0;
            }
            num >>= 1;
        }
        return res;
    }
}
