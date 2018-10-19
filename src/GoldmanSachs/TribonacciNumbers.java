package GoldmanSachs;

/*
https://www.geeksforgeeks.org/tribonacci-numbers/

The tribonacci series is a generalization of the Fibonacci sequence where each term is the sum of the three preceding terms.

The Tribonacci Sequence :
0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852… so on

General Form of Tribonacci number:
a(n) = a(n-1) + a(n-2) + a(n-3)
with
a(0) = a(1) = 0, a(2) = 1.

solution
1. recursion
2. dp
3. optimize dp
4. matrix exponentiation
 */
public class TribonacciNumbers {

    static int printTribRec(int n)
    {

        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;
        else
            return printTribRec(n - 1) +
                    printTribRec(n - 2) +
                    printTribRec(n - 3);
    }

    static void printTrib(int n)
    {
        for (int i = 1; i < n; i++)
            System.out.print(printTribRec(i)
                    +" ");
    }

    // Driver code
    public static void main(String args[])
    {
        int n = 10;

        printTrib(n);
    }

    static void printTribDp(int n)
    {
        int dp[]=new int[n];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < n; i++)
            dp[i] = dp[i - 1] +
                    dp[i - 2] +
                    dp[i - 3];

        for (int i = 0; i < n; i++)
            System.out.print(dp[i] + " ");
    }

    static void printTribDpOptimize(int n)
    {
        if (n < 1)
            return;

        // Initialize first
        // three numbers
        int first = 0, second = 0;
        int third = 1;

        System.out.print(first + " ");
        if (n > 1)
            System.out.print(second + " ");

        if (n > 2)
            System.out.print(second + " ");

        // Loop to add previous
        // three numbers for
        // each number starting
        // from 3 and then assign
        // first, second, third
        // to second, third, and curr
        // to third respectively
        for (int i = 3; i < n; i++)
        {
            int curr = first + second + third;
            first = second;
            second = third;
            third = curr;

            System.out.print(curr +" ");
        }
    }


    static void multiply(int T[][], int M[][])
    {
        int a, b, c, d, e, f, g, h, i;
        a = T[0][0] * M[0][0] +
                T[0][1] * M[1][0] +
                T[0][2] * M[2][0];
        b = T[0][0] * M[0][1] +
                T[0][1] * M[1][1] +
                T[0][2] * M[2][1];
        c = T[0][0] * M[0][2] +
                T[0][1] * M[1][2] +
                T[0][2] * M[2][2];
        d = T[1][0] * M[0][0] +
                T[1][1] * M[1][0] +
                T[1][2] * M[2][0];
        e = T[1][0] * M[0][1] +
                T[1][1] * M[1][1] +
                T[1][2] * M[2][1];
        f = T[1][0] * M[0][2] +
                T[1][1] * M[1][2] +
                T[1][2] * M[2][2];
        g = T[2][0] * M[0][0] +
                T[2][1] * M[1][0] +
                T[2][2] * M[2][0];
        h = T[2][0] * M[0][1] +
                T[2][1] * M[1][1] +
                T[2][2] * M[2][1];
        i = T[2][0] * M[0][2] +
                T[2][1] * M[1][2] +
                T[2][2] * M[2][2];
        T[0][0] = a;
        T[0][1] = b;
        T[0][2] = c;
        T[1][0] = d;
        T[1][1] = e;
        T[1][2] = f;
        T[2][0] = g;
        T[2][1] = h;
        T[2][2] = i;
    }

    // Recursive function to raise
    // the matrix T to the power n
    static void power(int T[][], int n)
    {
        // base condition.
        if (n == 0 || n == 1)
            return;
        int M[][] = {{ 1, 1, 1 },
                { 1, 0, 0 },
                { 0, 1, 0 }};

        // recursively call to
        // square the matrix
        power(T, n / 2);

        // calculating square
        // of the matrix T
        multiply(T, T);

        // if n is odd multiply
        // it one time with M
        if (n % 2 != 0)
            multiply(T, M);
    }

    static int tribonacciMatrixExponentiation(int n)
    {
        int T[][] = {{ 1, 1, 1 },
                { 1, 0, 0 },
                { 0, 1, 0 }};

        // base condition
        if (n == 0 || n == 1)
            return 0;
        else
            power(T, n - 2);

        // T[0][0] contains the
        // tribonacci number so
        // return it
        return T[0][0];
    }
}
