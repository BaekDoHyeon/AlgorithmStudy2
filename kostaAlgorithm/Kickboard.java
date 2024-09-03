package 알고리즘_강의.kostaAlgorithm;
import java.io.*;

// 1시간
public class Kickboard {

	static int M;
	static int N;
	static int[] pointX = {-1, 0, 1, 0};
	static int[] pointY = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;

	public static int execute(File path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));

		String line = reader.readLine();
		String[] NM = line.split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			line = reader.readLine();
			String[] input = line.split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(input[j]);
		}

		visited[0][0] = true;
		DFS(0, 0);

		return count;
	}

	private static void DFS(int x, int y) {
		if (x == N-1 && y == M-1) count++;
		else {
			for(int i = 0; i < pointX.length; i++) {
				int afterX = x + pointX[i];
				int afterY = y + pointY[i];

				if(afterX >= 0 && afterX < N && afterY >= 0 && afterY < M && map[x][y] > map[afterX][afterY] && !visited[afterX][afterY]) {
					visited[afterX][afterY] = true;
					DFS(afterX, afterY);
					visited[afterX][afterY] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println(execute(new File("/Users/baegdohyeon/Study_Spring_복습/Spring_스프링고급_김영한/codingtest/src/main/java/알고리즘_강의/kostaAlgorithm/input.txt").getAbsoluteFile()));
	}
}
