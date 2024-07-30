package 알고리즘_강의.연습.재귀함수;

import java.util.Scanner;

/*
    [ 피보나치 재귀(메모이제이션) ]
    입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력 되면 1 1 2 3 5 8 13을 출력 하면 된다.

    [입력 예]
    10 (첫 줄에 총 항수 N(3<=N<=45)이 입력 된다.)

    [출력 예]
    1 1 2 3 5 8 13 21 34 55 (첫 줄에 피보나치 수열 출력 합니다.)
 */
//코딩 인터뷰에서 자주 나오는 문제라고 합니다!
public class FibonacciSequence {

    static int[] fibo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fibo = new int[n+1];
        DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    static int DFS(int n) {

        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n]=1;
        else if (n == 2) return fibo[n]=1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

}
