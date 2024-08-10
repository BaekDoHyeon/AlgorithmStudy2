package 알고리즘_강의.dfsbfs.dfs.미로탐색;

import java.util.Scanner;

// README.md 참고
public class LabyrinthSearch {

    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[8][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 미로 입력
        for (int i = 1; i < board.length; i++)
            for (int j = 1; j < board.length; j++)
                board[i][j] = sc.nextInt();

        DFS(1, 1); //시작위치 1, 1
        System.out.println(count);
    }

    static void DFS(int x, int y) {
        if (x == 7 && y ==7)
            count++;
        else {
            for (int i = 0; i < 4; i++) {
                //현재 위치에서 상하좌우의 값을 살펴본 후 0 이라면 해당 위치로 이동..
                int afterX = x + dx[i];
                int afterY = y + dy[i];

                if (afterX > 0 && afterY > 0 && afterX < 8 && afterY < 8 && board[afterX][afterY] == 0) {
                    board[x][y] = 1;
                    DFS(afterX, afterY);
                    board[x][y] = 0;
                }
            }
        }
    }
}
