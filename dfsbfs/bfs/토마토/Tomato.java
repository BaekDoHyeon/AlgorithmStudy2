package 알고리즘_강의.dfsbfs.bfs.토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// README.md 참고...
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Tomato {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static Queue<Point> queue = new LinkedList<>();

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //가로 칸 수
        n = sc.nextInt();
        //세로 칸 수
        m = sc.nextInt();

        board = new int[m][n];
        dis = new int[m][n];

        //토마토 위치 입력
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        //처음부터 익어있는 토마토를 저장
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 1)
                    queue.offer(new Point(i, j));

        //로직 실행...
        BFS();

        int max = 0;
        boolean noTomato = false;

        //토마토가 전부 익기까지의 최소일수를 구한다.
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dis[i][j]);

        //아직 익지 않은 토마토가 있는지 확인 -> 있다면 noTomato 플래그를 true 로 변경하여 -1 출력 유도
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 0) {
                    noTomato = true;
                    return;
                }

        //출력
        if (noTomato) System.out.println(-1);
        else if (max == 0) System.out.println(0);
        else System.out.println(max);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int afterX = cur.x + dx[i];
                int afterY = cur.y + dy[i];

                if (afterX >= 0 && afterY >= 0 && afterX < m && afterY < n && board[afterX][afterY] == 0) {
                    queue.offer(new Point(afterX, afterY));
                    dis[afterX][afterY] = dis[cur.x][cur.y] + 1;
                    board[afterX][afterY] = 1;
                }
            }
        }
    }
}
