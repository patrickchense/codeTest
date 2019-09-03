package amazon;

import java.util.LinkedList;
import java.util.Queue;

/*
You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
There are other explorers trying to find the treasure. So you must figure out a shortest route to one of the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from one of the starting point(marked as 'S') of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in.
Output the minimum number of steps to get to any of the treasure.
e.g.
Input
[
[‘S’, ‘O’, ‘O’, 'S', ‘S’],
[‘D’, ‘O’, ‘D’, ‘O’, ‘D’],
[‘O’, ‘O’, ‘O’, ‘O’, ‘X’],
[‘X’, ‘D’, ‘D’, ‘O’, ‘O’],
[‘X', ‘D’, ‘D’, ‘D’, ‘O’],
]

Output
5
Explanation
You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0). Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).

 */
public class TreasureIslandII {

	public static void main(String[] args) {
		//find all the start

		//find all the X

		// dfs mulitple times

		// O(m * n * ( r * c))


	}

	static int min = Integer.MAX_VALUE;
	private static void dfs(int r, int c, int count, char [][]grid) {
		if (!isValid(r, c, grid)) return ;
		if (grid[r][c] == 'X'){
			min = Math.min(min, count);
			return;
		}
		grid[r][c]= 'D';
		dfs(r+1, c, count + 1, grid);
		dfs(r-1, c, count + 1, grid);
		dfs(r, c+1, count + 1, grid);
		dfs(r, c-1, count + 1, grid);

	}

	private static boolean isValid(int r, int c, char [][]grid) {
		if (r < 0 || r>= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 'D')return false;
		return true;
	}

	final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int shortestPath(char[][] islands){
		if(islands.length == 0 || islands[0].length == 0) return -1;
		int R = islands.length, C = islands[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int steps = 1;
		// add all sources to queue and set 'visited'.
		for(int i = 0; i < R; ++i){
			for(int j = 0; j < C; ++j){
				if(islands[i][j] == 'S'){
					queue.add(new int[]{i, j}); islands[i][j] = 'D';
				}
			}
		}
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; ++i){
				int[] pos = queue.poll();
				for(int[] dir: dirs){
					int x = pos[0] + dir[0], y = pos[1] + dir[1];
					if(x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D') continue;
					if(islands[x][y] == 'E') return steps;
					queue.add(new int[]{x, y});
					islands[x][y] = 'D';
				}
			}
			++steps;
		}
		return -1;
	}
}

// Amazon | OA 2019 | Shortest Path From Multiple Sources
// https://leetcode.com/discuss/interview-question/356150

class Main {
	final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int shortestPath(char[][] islands){
		if(islands.length == 0 || islands[0].length == 0) return -1;
		int R = islands.length, C = islands[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int steps = 1;
		// add all sources to queue and set 'visited'.
		for(int i = 0; i < R; ++i){
			for(int j = 0; j < C; ++j){
				if(islands[i][j] == 'S'){
					queue.add(new int[]{i, j}); islands[i][j] = 'D';
				}
			}
		}
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; ++i){
				int[] pos = queue.poll();
				for(int[] dir: dirs){
					int x = pos[0] + dir[0], y = pos[1] + dir[1];
					if(x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D') continue;
					if(islands[x][y] == 'E') return steps;
					queue.add(new int[]{x, y});
					islands[x][y] = 'D';
				}
			}
			++steps;
		}
		return -1;
	}
	public static void main(String[] args) {
		Main main = new Main();
		char[][] testcase = { {'S', 'O', 'O', 'S'},
				{'D', 'O', 'D', 'D'},
				{'O', 'O', 'O', 'E'},
				{'E', 'D', 'D', 'O'}};
		System.out.println(main.shortestPath(testcase));
	}
}