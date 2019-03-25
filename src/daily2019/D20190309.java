package daily2019;

/*
Given a positive integer n, find the smallest number of squared integers which sum to n.

For example, given n = 13, return 2 since 13 = 32 + 22 = 9 + 4.

Given n = 27, return 3 since 27 = 32 + 32 + 32 = 9 + 9 + 9.

@Facebook

@answered
@review
@dp
@recursive

https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-numbers-are-required-whose-square-sum-is-equal-to-a-given-number/ dp
https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/  recursive

关于square的一组题
https://www.geeksforgeeks.org/paper-cut-minimum-number-squares/
https://www.geeksforgeeks.org/paper-cut-minimum-number-squares-set-2/
https://www.geeksforgeeks.org/find-smallest-number-n-n-xor-n1-equals-given-k/
https://www.geeksforgeeks.org/find-number-perfect-squares-two-given-numbers/
https://www.geeksforgeeks.org/check-whether-number-can-represented-sum-two-squares/
https://www.geeksforgeeks.org/count-number-of-squares-in-a-rectangle/
https://www.geeksforgeeks.org/program-to-find-number-of-squares-on-a-chessboard/
https://www.geeksforgeeks.org/program-to-count-number-of-distinct-squares-and-cubes-upto-n/
https://www.geeksforgeeks.org/number-of-squares-of-side-length-required-to-cover-an-nm-rectangle/

 */
public class D20190309 {
    public static void main(String[] args) {
        System.out.println(smallestSquaredNumberSum(12));
        System.out.println(smallestSquaredNumberSum(13));
        System.out.println(smallestSquaredNumberSum(27));
    }

    // 数量最小，那么要从这个数的sqrt找起
    public static int smallestSquaredNumberSum(int t) {
        int sqrt = (int) Math.sqrt(t);
        if (sqrt * sqrt == t) return 1;
        // 暴力?
        return solveUsingDP(t, sqrt);
    }

    public static int solveUsingDP(int n, int options) {
        int MN[] = new int[n+1]; // Minimum numbers required whose sum is = n
        MN[0] = 0; // if number is 0 the answer is 0.
        int[] NUM = new int[options+1];
        // solve in bottom up manner
        for (int number = 1; number <= n; number++) {
            // reset the NUM[] for new i
            for (int j = 0; j <= options; j++) {
                NUM[j] = 0;
            }
            // now try every option one by one and fill the solution in NUM[]
            for (int j = 1; j <= options; j++) {
                // check the criteria
                if (j * j <= number) {
                    // select the number, add 1 to the solution of number-j*j
                    NUM[j] = MN[number - j * j] + 1;//把所有平方<当前number的差都记录下来+1(比如number==4时，j=1,j=2,时， MN[3] = 1, MN[0] = 1, number =5, MN[4] = 1, MN[1] =1
                    // number ==6, MN[5] = 1, MN[2] =1, 7, MN[6] = 1, MN[3] = 2, 8, MN[7] =1, MN[4] = 2, 9, MN[8] = 1, MN[5] = 2, MN[0] = 2 ..
                } else {
                    break;
                }
            }

            //Now choose the optimal solution from NUM[]
            MN[number]=-1;
            for(int j=1;j<NUM.length;j++){
                if(NUM[j]>0 && (MN[number]==-1 || MN[number]>NUM[j])){
                    MN[number]=NUM[j];
                }
            }
        }
        return MN[n];
    }
}
