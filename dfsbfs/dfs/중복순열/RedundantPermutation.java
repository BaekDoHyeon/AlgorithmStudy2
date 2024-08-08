package 알고리즘_강의.dfsbfs.dfs.중복순열;

import java.util.Scanner;

/*
    [ 중복 순열 구하기 ]

    1부터 N까지 번호가 적힌 구슬이 있다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력

    [입력 설명]
    첫 번째 줄 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어진다.

    [출력 설명]
    첫 번째 줄에 결과를 출력한다.
    출력순서는 사전순으로 오름차순으로 출력한다.

    [입력]
    3 2

    [출력]
    1 1
    1 2
    1 3
    2 1
    2 2
    2 3
    3 1
    3 2
    3 3
 */
public class RedundantPermutation {

    static int[] numbers;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //자연수 범위 3~n (3<=N<=10)
        n = sc.nextInt();

        //수열 개수
        m = sc.nextInt();

        numbers = new int[n];
        int[] result = new int[m];

        for (int i = 0; i<n; i++)
            numbers[i] = i+1;

        DFS(1, 0, result);
    }

    static void DFS(int l, int cnt, int[] result) {
        if (l == n && cnt != 2) return;
        if (cnt == m) {
            for (int i : result)
                System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                //포함한다.
                result[cnt] = numbers[i];
                DFS(l + 1, cnt + 1, result);

                //포함하지 않는다.
                result[cnt] = 0;
                DFS(l + 1, cnt, result);
            }
        }
    }
}
