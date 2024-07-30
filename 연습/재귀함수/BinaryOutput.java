package 알고리즘_강의.연습.재귀함수;

import java.util.Scanner;

/*
    [ 이진수 출력(재귀) ]

    10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 출력. 재귀함수 사용!

    [입력 예]
    11 (첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어진다.

    [출력 예]
    1011 (첫 번째 줄에 이진수를 출력)
 */
public class BinaryOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DFS(n);
    }

    static void DFS(int n) {
        if (n == 0) return;
        DFS(n/2);
        System.out.print(n % 2);
    }
}
