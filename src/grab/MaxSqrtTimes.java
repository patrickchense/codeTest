package grab;

/*
https://discuss.codechef.com/t/maximum-no-of-repeated-square-root-operations-that-can-be-performed-on-a-no-in-the-range/22118


 */
public class MaxSqrtTimes {

    public static void main(String[] args) {
        System.out.println(solution(10,20));
        System.out.println(solution(6000,7000));
    }



    public static int solution(int a, int b) {
        int count = 0;
        while (a <= b) {
            int m = (int) (Math.ceil(Math.sqrt(a)));
            int n = (int) (Math.floor(Math.sqrt(b)));
            if (m == a && n == b)
                break;
            a = m;
            b = n;
            if (a <= b)
                count++;
        }
        return count;
    }
}
