package 알고리즘_강의.dfsbfs.dfs.섬나라아일랜드;

import java.util.Scanner;

// README.md 참고... DFS 풀이...
public class IslandNationOfIreland {

    static int n, islandCnt;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n*n 격자판 생성
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    islandCnt++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(islandCnt);
    }

    static void DFS(int curX, int curY) {
        board[curX][curY] = 0;
        for (int i  = 0; i < dx.length; i++) {
            int afterX = curX + dx[i];
            int afterY = curY + dy[i];

            if (afterX >= 0 && afterY >= 0 && afterX < n && afterY < n && board[afterX][afterY] == 1)
                DFS(afterX, afterY);
        }
    }
}
