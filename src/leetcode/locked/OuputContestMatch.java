package leetcode.locked;

/*
leetcode 544
https://leetcode.com/articles/output-contest-matches/
During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team,
which is a good strategy to make the contest more interesting. Now, you're given n teams, you need to output their final contest matches in the form of a string.

The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is the strongest team and Rank n is the weakest team.)
 We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition.
  During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.

Example 1:
Input: 2
Output: (1,2)
Explanation:
Initially, we have the team 1 and the team 2, placed like: 1,2.
Then we pair the team (1,2) together with '(', ')' and ',', which is the final answer.
Example 2:
Input: 4
Output: ((1,4),(2,3))
Explanation:
In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
And we got (1,4),(2,3).
In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
And we got the final answer ((1,4),(2,3)).
Example 3:
Input: 8
Output: (((1,8),(4,5)),((2,7),(3,6)))
Explanation:
First round: (1,8),(2,7),(3,6),(4,5)
Second round: ((1,8),(4,5)),((2,7),(3,6))
Third round: (((1,8),(4,5)),((2,7),(3,6)))
Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
Note:
The n is in range [2, 212].
We ensure that the input n can be converted into the form 2k, where k is a positive integer.

@solved

还是考察的思维和string的拼接

 */
public class OuputContestMatch {

    /*
    O(nlogn) time, O(n) space
     */
    public static String OuputContestMatch(int n) {

        StringBuilder sb = new StringBuilder();
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = "" + i;
        }
        while (n > 2) {
            for (int i = 1; i <= n / 2; i++) {
                res[i - 1] = "(" + res[i - 1] + "," + res[n - i] + ")";
            }
            n = n / 2;
        }
        return "(" + res[0] + "," + res[1] + ")";
    }

    public static void main(String[] args) {
        System.out.println(OuputContestMatch(8));
        System.out.println(OuputContestMatch(16));
        System.out.println(OuputContestMatch(4));
    }

    /*
    team = [1, 16, 8, 9, 4, 13, 5, 12, 2, 15, 7, 10, 3, 14, 6, 11]

One thing we might notice is that adjacent numbers sum to 17. More specifically, indices that are 0 and 1 (mod 2) sum to 17.
Also, indices 0 and 2 (mod 4) sum to 9, indices 0 and 4 (mod 8) sum to 5, and so on.

The pattern in general is: indices 0 and 2**r (mod 2**(r+1)) sum to N * 2**-r + 1.

If we want to find the next team[i], then the lowest bit of i will help determine it's lower neighbor.
For example, team[12] = team[0b1100] has lower bit w = 4 = 0b100, so 12 has lower neighbor 12 - w = 8, and also those team numbers sum to N / w + 1.
     */
    int[] team;
    int t;
    StringBuilder ans;

    public String findContestMatch(int n) {
        team = new int[n];
        t = 0;
        ans = new StringBuilder();
        write(n, Integer.numberOfTrailingZeros(n));
        return ans.toString();
    }

    public void write(int n, int round) {
        if (round == 0) {
            int w = Integer.lowestOneBit(t);
            team[t] = w > 0 ? n / w + 1 - team[t - w] : 1;
            ans.append("" + team[t++]);
        } else {
            ans.append("(");
            write(n, round - 1);
            ans.append(",");
            write(n, round - 1);
            ans.append(")");
        }
    }
}
