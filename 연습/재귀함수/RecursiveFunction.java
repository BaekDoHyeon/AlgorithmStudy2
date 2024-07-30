package 알고리즘_강의.연습.재귀함수;

import java.util.Scanner;

/*
    [ 재귀함수(스택프레임) 연습 ]

     자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성.

     [입력 예]
     3 (정수 3<=N<=10)

     [출력 예]
     1 2 3
 */
public class RecursiveFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //3
        int n = sc.nextInt();

        DFS(n);
    }

    static void DFS(int n) {
        if (n == 0) return;
        DFS(n-1);
        System.out.print(n + " ");
    }
}
