package 알고리즘_강의.twopointers.연속된자연수의합;

import java.util.Scanner;

/*
[설명]
N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

[입력]
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

[출력]
첫 줄에 총 경우수를 출력합니다.

[예시 입력 1]
15

[예시 출력 1]
3
 */
public class SumConsecutiveNumbers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        int value = 1;

        // 1~N 까지 값을 저장
        for (int i = 0; i < num; i++)
            arr[i] = value++;

        System.out.println(solution(num, arr));
    }

    static int solution(int num, int[] arr) {
        int count = 0, cnt = 1;
        num--; //처음 시작할 때, 1 값을 빼준다.

        while (num > 1) {
            cnt++;
            num -= cnt;

            if (num % cnt == 0) count++;
        }

        return count;
    }
}
