package dp;

/*
https://algorithms.tutorialhorizon.com/dynamic-programming-minimum-numbers-are-required-whose-square-sum-is-equal-to-a-given-number/

@dp

Given a number, Write an algorithm to find out minimum numbers required whose square is equal to the number.

Given Number: 12

Numbers whose sum of squares are equal to 12.

12+12+12+12+12+12+12+12+12+12+12+12 = 12

22+22+22 = 12

32+12+12+12 = 12

Answer: 3 numbers (2,2,2)

@Google

@answered
@review


大概理解了这里的dp逻辑，因为这题的需要的中间存储（平方值），也需要记录结果
所以, NUM 是用来记录 j * j 的结果，然后标记已在MN中，MN最后多一位，用来存放最小值
 */
public class MinimumNumberRequired {

    public void solve(int n) {
        int options = (int) Math.sqrt(n);
        //solve using Dynamic programming
        System.out.println(solveUsingDP(n, options));
    }
    public int solveUsingDP(int n, int options) {
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
                if (j * j <= number) { // 如果一次遍历出现，多个j然后，跳出循环后，最小的保存起来
                    // select the number, add 1 to the solution of number-j*j
                    NUM[j] = MN[number - j * j] + 1;
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

    public static void main(String[] args) {
        int N = 12;
        MinimumNumberRequired s = new MinimumNumberRequired();
        s.solve(N);
    }
}
