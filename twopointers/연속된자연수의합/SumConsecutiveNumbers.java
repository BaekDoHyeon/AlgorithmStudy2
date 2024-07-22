package 알고리즘_강의.twopointers.연속된자연수의합;

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

import java.util.Scanner;

public class SumConsecutiveNumbers {

    //lt, rt -> lt 의 위치는 N을 2로 나눈 값보다 클 수가 없다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num]; // 투 포인터를 활용하여 문제를 풀려면 배열을 꼭 써야할듯? -> 컬렉션보다 배열이 접근 방법이 맞는가?
        int value = 1;

        // 1~N 까지 값을 저장
        for (int i = 0; i < num; i++)
            arr[i] = value++;

        System.out.println(solution(num, arr));
    }

    /*
        lt의 값이 증가되는 경우
            1) sum == num(조건값)
            2) sum > num

        rt의 값이 증가되는 경우
            1) sum < num
     */
    static int solution(int num, int[] arr) {
        int count = 0, sum = 0, lt = 0;

        for (int rt = 0; rt < num; rt++) {
            sum += arr[rt];

            if (sum == num)
                count++;

            // sum < num 일 경우이면서 lt 값이 조건값/2의 값과 동일할때만 반복을 돌리고, 그렇지 않으면 반복문을 빠져나와서 rt 값을 증가시킨다.
            while (sum >= num && lt <= num/2) {
                sum -= arr[lt++];

                if (sum == num) count++;
            }
        }


        return count;
    }
}
