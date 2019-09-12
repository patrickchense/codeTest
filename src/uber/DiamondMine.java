package uber;

/*
Task Description:
Diamond Mine is your new favorite game . Its map is represented as a square matrix. The board is filled with cells, and each cell will have an initial value as follows:
• A value ≥ 0 represents a path.
• A value of 1 represents a diamond.
• A value of −1 represents an obstruction.

The basic rules for playing Diamond Mine are as follows: • The player starts at (0, 0) and moves to (n−1, n−1), by moving right (→) or down (↓) through valid path cells. • After reaching (n−1, n−1), the player must travel back to (0, 0)by moving left (←) or up (↑) through valid path cells. • When passing through a path cell containing a diamond, the diamond is picked up. Once picked up, the cell becomes an empty path cell. • If there is no valid path between (0, 0) and (n−1, n−1), then no diamonds can be collected. • The ultimate goal is to collect as many diamonds as you can.
For example, consider the following grid:
[ [0 1]
[-1 0] ]
Start at the top left corner. Move right one, collecting a diamond. Move down one to the goal. Cell (1, 0) is blocked, so we can only return on the path we took initially. All paths have been explored, and 1 diamond was collected.

Function Description Complete the function collectMax. It must return an integer denoting the maximum number of diamonds you can collect given the current map.
collectMax has the following parameter(s):
mat[mat[0],...mat[n-1]]: an array of integers describing the game grid map Constraints
• 1 ≤ n ≤ 100
•−1 ≤ mat[i][j] ≤ 1

Case 0:
Sample Input :
[ [0 1 -1]
[1 0 -1]
[1 1 1] ]
Output: 5
Explanation :You can collect a maximum of 5 diamonds by taking the following path: (0, 0) → (0,1) → (1,1) → (2, 1) → (2, 2) → (2, 1) → (2, 0) → (1, 0) → (0, 0).

Case 1:
Sample Input:
[ [0 1 1]
[1 0 1]
[1 1 1]]
Output: 7
You can collect all 7 diamonds by following the
path:
0 → 1 → 1
↑ ↓
1 0 1
↑ ↓
1 ← 1 ← 1

Case 2:
Sample :
[[0 1 1]
[1 0 -1]
[1 1 -1]]
Output: 0
Explanation :The cell at (2, 2) is blocked, so you cannot collect any diamonds.
 */
public class DiamondMine {
}
