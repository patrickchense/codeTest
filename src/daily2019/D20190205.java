package daily2019;

/*
You have 100 fair coins and you flip them all at the same time. Any that come up tails you set aside. The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains?

Write a function that, given n, returns the number of rounds you'd expect to play until one coin remains.

@Microsoft

n /2 ...until n == 1?
好像不是这么算的？？？

 */
public class D20190205 {

    public static void main(String[] args) {
        System.out.println("play times:" + playtimes(100));
    }

    private static int playtimes(int n) {
        int c = 0;
        while (n > 1) {
            n /= 2;
            c++;
        }
        return c;
    }
}
