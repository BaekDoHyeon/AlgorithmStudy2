package 알고리즘_강의.dfsbfs.dfs.조합의경우수;

import java.util.Scanner;

/*
    [ 조합의 경우의 수 (메모이제이션) ]

    // 자세한 건 README.md 참고..

[입력]
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

[출력]
첫째 줄에 조합수를 출력합니다.

[예시 입력 1]
5 3

[예시 출력 1]
10

[예시 입력 2]
33 19

[예시 출력 2]
818809200
 */
public class NumCasesOfCombination {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1~n , 자연수 개수
        int n = sc.nextInt();

        // 뽑으려는 수의 개수
        int m = sc.nextInt();

        arr = new int[n+1][n+1];

        System.out.println(DFS(n,m));
    }

    static int DFS(int n, int m) {
        if (n == m || m == 0) return 1;

        if (arr[n][m] == 0)
            return arr[n][m] =  DFS(n-1, m-1) + DFS(n-1, m);
        else
            return arr[n][m];
    }
}
