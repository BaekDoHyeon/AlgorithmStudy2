package 알고리즘_강의.연습.재귀함수;

import java.util.Scanner;

/*
    자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
    예를 들어 5! = 5*4*3*2*1=120 입니다.

    [입력 예]
    5

    [출력 예]
    120
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(DFS(n));
    }

    static int DFS(int n) {
        if (n == 1) return 1;

        return n * DFS(n-1);
    }
}
