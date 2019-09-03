package amazon;

import java.util.*;

/*
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
Output the minimum number of steps to get to the treasure.
e.g.
Input
[
[‘O’, ‘O’, ‘O’, ‘O’],
[‘D’, ‘O’, ‘D’, ‘O’],
[‘O’, ‘O’, ‘O’, ‘O’],
[‘X’, ‘D’, ‘D’, ‘O’],
]

Output from aonecode.com
Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.

 */
public class TreasureIslandI {

	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'0', '0', '0', '0'}, {'D', '0', 'D', '0'}, {'0', '0', '0', '0'}, {'X', 'D', 'D', '0'}};
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		List<int[]> steps = new ArrayList<>();
		List<int[]> res = new ArrayList<>();
//		dfs(matrix, 0, 3, 4, 4, steps, res, visited);
		System.out.println(treasureIsland(matrix));
//		System.out.println("result:");
//		print(res);
	}


	public static boolean dfs(char[][] matrix, int x, int y, int xlen, int ylen, List<int[]> steps, List<int[]> shortest, boolean[][] visited) {
		if (x < 0 || x >= xlen) return false;
		if (y < 0 || y >= ylen) return false;
		if (visited[x][y]) return false;
		if (matrix[x][y] == 'X') {
			steps.add(new int[]{x, y});
			return true;
		}
		if (matrix[x][y] == 'D') return false;
		// 0
		steps.add(new int[]{x, y});
		visited[x][y] = true;
		boolean isFound = false;
		if (dfs(matrix, x - 1, y, xlen, ylen, steps, shortest, visited)) {
			replace(steps, shortest);
		}
		if (dfs(matrix, x + 1, y, xlen, ylen, steps, shortest, visited)) {
			replace(steps, shortest);
		}
		if (dfs(matrix, x , y - 1, xlen, ylen, steps, shortest, visited)) {
			replace(steps, shortest);
		}
		if (dfs(matrix, x, y + 1, xlen, ylen, steps, shortest, visited)) {
			replace(steps, shortest);
		}
		steps.remove(steps.size() - 1);
		return false;
	}

	public static void replace(List<int[]> steps, List<int[]> shortest) {
		System.out.println("step:");
		print(steps);
		System.out.println("shortest:");
		print(shortest);
		if (shortest.isEmpty()) {
			shortest.addAll(steps);
		}
		else if (shortest.size() > steps.size()) {
			shortest.clear();
			shortest.addAll(steps);
		}
	}

	public static void print(List<int[]> res) {
		res.forEach(step -> System.out.print("(" + step[0] + "," + step[1] + ")"));
		System.out.println();
	}

	static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int treasureIsland(char[][] island) {
		if (island == null || island.length == 0) return 0;

		int steps = 0;
		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(0, 0));
		boolean[][] visited = new boolean[island.length][island[0].length];
		visited[0][0] = true;
		int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		// bfs
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Coordinate coordinate = queue.poll();
				int x = coordinate.x;
				int y = coordinate.y;
				if (island[x][y] == 'X') return steps;

				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];

					if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
							island[newX][newY] != 'D' && !visited[newX][newY]) {
						queue.add(new Coordinate(newX, newY));
						visited[newX][newY] = true;
					}
				}
			}
			steps++;
		}

		return 0;


	}


	public int minSteps(char[][] grid) {
		Coordinate destination = checkPath(grid);
		Queue<Coordinate> coordinates = new ArrayDeque<>();
		coordinates.add(new Coordinate(0, 1));
		int i = 0;
		int j = 1;
		boolean isFound = false;
		while (!isFound) {
			System.out.println("Values [i][j] " + i + "," + j + " : " + grid[i][j]);

			if (grid[i][j] == 'X') {
				isFound = true;
			} else if (grid[i + 1][j] != 'D') {
				i++;
				coordinates.add(new Coordinate(i, j));
			} else if (destination.y <= j && grid[i][j - 1] != 'D') {
				j--;
				coordinates.add(new Coordinate(i, j));
			} else {
				j++;
				coordinates.add(new Coordinate(i, j));
			}
		}
		return coordinates.size();
	}

	private Coordinate checkPath(char[][] grid) {
		Coordinate destination = null;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'X') {
					destination = new Coordinate(i, j);
					break;
				}
			}
			if (destination != null) {
				break;
			}
		}
		return destination;
	}


	//dfs
	private static int min = Integer.MAX_VALUE ;

	public static int treasureIsland_DFS(char [][]grid) {

		dfs(0, 0, 0, grid);
		return min;
	}

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
}
