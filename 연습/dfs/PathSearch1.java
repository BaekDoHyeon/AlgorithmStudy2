package 알고리즘_강의.연습.dfs;

import java.util.Scanner;

/*
    경로 탐색(인접 행렬)
    방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램 작성

    [입력]
    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5

    [출력]
    6
 */
public class PathSearch1 {

    static int result = 0;
    static int[][] arr;
    static int[] ch;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //전체 노드의 개수(정점의 개수)
        n = sc.nextInt();

        //간선의 개수
        int m = sc.nextInt();

        arr = new int[n+1][n+1];
        ch = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1; // a -> b 이동 가능 여부 체크
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(result);
    }

    static void DFS(int num) {
        if (num == n) result++;

        for (int i = 1; i <= n; i++) {
            if (arr[num][i] == 1 && ch[i] == 0) { //num -> i 으로 이동할 수 있으면서 i를 지나온 적이 없다면..
                ch[i] = 1;
                DFS(i);
                ch[i] = 0;
            }
        }
    }
}
