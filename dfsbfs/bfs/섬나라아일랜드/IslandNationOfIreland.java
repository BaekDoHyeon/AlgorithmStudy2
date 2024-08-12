package 알고리즘_강의.dfsbfs.bfs.섬나라아일랜드;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// README.md 참고... BFS 풀이...
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

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
                    BFS(new Point(i, j));
                }
            }
        }

        System.out.println(islandCnt);
    }

    static void BFS(Point curPoint) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(curPoint);
        board[curPoint.x][curPoint.y] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int afterX = cur.x + dx[i];
                int afterY = cur.y + dy[i];

                if (afterX >= 0 && afterY >=0 && afterX < n && afterY < n && board[afterX][afterY] == 1) {
                    queue.offer(new Point(afterX, afterY));
                    board[afterX][afterY] = 0;
                }
            }
        }
    }
}
