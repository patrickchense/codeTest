package daily2019;

/*
You are given a 2-d matrix where each cell consists of either /, \, or an empty space. Write an algorithm that determines into how many regions the slashes divide the space.

For example, suppose the input for a three-by-six grid is the following:

\    /
 \  /
  \/
Considering the edges of the matrix as boundaries, this divides the grid into three triangles, so you should return 3.

@Uber
@medium

@solved
 */
public class D20190801 {

	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'\\', ' ', ' ', ' ', ' ', '/'}, {' ', '\\', ' ', ' ', '/', ' '}, {' ', ' ', '\\', '/', ' ', ' '}};
		System.out.println(findZone(matrix));
		matrix = new char[][]{{'\\', ' ', ' ', ' ', ' ', '/'}, {' ', '\\', ' ', ' ', '/', ' '}, {' ', ' ', '\\', '/', ' ', ' '}};
		System.out.println(findZone2(matrix));
	}

	// the point is frind \/  only adjecent \/ can split
	// loop space, if connected not change, otherwise + 1
	// O(n ^ 2) O(n ^ 2)
	public static int findZone(char[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == ' ' && !visited[i][j]) {
					dfs(matrix, i, j, visited);
					count++;
				}

			}
		}
		return count;
	}

	private static void dfs(char[][] matrix, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
		if (matrix[i][j] != ' ') return;
		if (visited[i][j]) return;
		visited[i][j] = true;

		dfs(matrix, i-1, j, visited);
		dfs(matrix, i+1, j, visited);
		dfs(matrix, i, j-1, visited);
		dfs(matrix, i, j+1, visited);
	}

	// optimize, change in place
	public static int findZone2(char[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == ' ' && matrix[i][j] != '1') {
					dfs(matrix, i, j);
					count++;
				}

			}
		}
		return count;
	}


	private static void dfs(char[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
		if (matrix[i][j] != ' ') return;
		if (matrix[i][j] == '1') return;
		matrix[i][j] = '1';

		dfs(matrix, i-1, j );
		dfs(matrix, i+1, j );
		dfs(matrix, i, j-1 );
		dfs(matrix, i, j+1);
	}
}
