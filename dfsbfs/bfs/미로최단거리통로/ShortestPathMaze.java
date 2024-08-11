package 알고리즘_강의.dfsbfs.bfs.미로최단거리통로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ShortestPathMaze {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 미로 입력
        for (int i = 1; i < board.length; i++)
            for (int j = 1; j < board.length; j++)
                board[i][j] = sc.nextInt();

        BFS(new Point(1, 1)); //시작위치 1, 1

        if (board[7][7] != 1)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);
    }

    static void BFS(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        board[p.x][p.y] = 1;

        while (!queue.isEmpty()) {
            Point curXY = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int afterX = curXY.x + dx[i];
                int afterY = curXY.y + dy[i];

                //위치를 이동할 수 있는 조건
                if (afterX > 0 && afterX < 8 && afterY > 0 && afterY < 8 && board[afterX][afterY] == 0) {
                    queue.offer(new Point(afterX, afterY));
                    board[afterX][afterY] = 1;
                    dis[afterX][afterY] = dis[curXY.x][curXY.y] + 1;
                }
            } // for 문 종료
        } // while 문 종료
    }
}
