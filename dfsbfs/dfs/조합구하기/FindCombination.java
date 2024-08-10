package 알고리즘_강의.dfsbfs.dfs.조합구하기;

import java.util.Scanner;

/*
    [ 조합 구하기 ]
    1 부터 N 까지 번호가 적힌 구슬이 있다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램 작성

    [입력 설명]
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어진다.

    [출력 설명]
    첫 번째 줄에 결과를 출력한다.
    출력순서는 사전순으로 오름차순으로 출력한다.

    [입력 예제]
    4 2

    [출력 예제]
    1 2
    1 3
    1 4
    2 3
    2 4
    3 4
 */
public class FindCombination {

    static int n, m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        DFS(0, 1);
    }

    // l = level , s = startNum
    static void DFS(int l, int s) {
        if (l == m) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                arr[l] = i;
                DFS(l + 1, i + 1);
            }
        }
    }
}
