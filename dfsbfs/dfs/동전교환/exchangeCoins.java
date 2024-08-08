package 알고리즘_강의.dfsbfs.dfs.동전교환;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
[설명]
다음과 같이 여러 단위의 동전 들이 주어져 있을때 거스름 돈을 가장 적은 수의 동전 으로 교환 해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

[입력]
첫 번째 줄에는 동전의 종류 개수 N(1<=N<=12)이 주어 진다.
두 번째 줄에는 N개의 동전의 종류가 주어 지고, 그 다음 줄에 거슬러 줄 금액 M(1<=M<=500)이 주어 진다.각 동전의 종류는 100원을 넘지 않는다.

[출력]
첫 번째 줄에 거슬러 줄 동전의 최소 개수를 출력 한다.

[예시 입력]
3
1 2 5
15

[예시 출력]
3
*/
public class exchangeCoins {

    static Integer[] coins;
    static int minCoinCnt = Integer.MAX_VALUE;

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //동전의 종류 개수
        n = sc.nextInt();

        coins = new Integer[n];


        //동전의 종류
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());

        //거슬러줄 금액
        m = sc.nextInt();

        DFS(0, 0);
        System.out.println(minCoinCnt);
    }

    static void DFS(int sum, int coinCnt) {
        if (coinCnt > minCoinCnt || sum > m) return; //현재 나의 거슬러줄 코인의 개수가 최소값보다 커졌다면 종료 혹은 거슬러줄 금액보다 커진다면 종료
        if (sum == m)
            minCoinCnt = coinCnt;
        else
            for (int i = 0; i < n; i++) //코인을 추가한다.
                DFS(sum + coins[i], coinCnt + 1);
    }
}
