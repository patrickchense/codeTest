package uber;

/*
Given an array arr of unique integers [1..n]. The array represents n different players at a tournament and their overall strength, and the first two slots in the array represent the current match. The stronger player always wins and the weaker player is moved to the end of the array. The tournament ends when a player wins k matches in a row. Find the winner.

Example:

Input: arr = [2, 1, 3, 4, 5], k = 2
Output: 5
Explanation:
[2 1] 3 4 5 | player 2 vs. player 1, player 2 wins and player 1 is moved to the end
[2 3] 4 5 1 | player 2 vs. player 3, player 3 wins
[3 4] 5 1 2 | player 4 wins
[4 5] 1 2 3 | player 5 wins
[5 1] 2 3 4 | player 5 wins again, that's k times in a row so 5 is the overall winner
Expected O(n) time and O(1) space solution. arr is immutable.

@phone
 */
public class Tournament {
}
