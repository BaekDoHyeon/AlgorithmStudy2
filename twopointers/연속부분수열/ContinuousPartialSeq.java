package 알고리즘_강의.twopointers.연속부분수열;

import java.util.Scanner;

/*
[설명]
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성 하세요.
만약 N=8, M=6이고 수열이 다음과 같다면
1 2 1 3 1 1 1 2
합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지 입니다.

[입력]
첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
수열의 원소값은 1,000을 넘지 않는 자연수이다.

[출력]
첫째 줄에 경우의 수를 출력한다.

[예시 입력 1]
8 6
1 2 1 3 1 1 1 2

[예시 출력 1]
3
*/
public class ContinuousPartialSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //숫자 개수
        int n = sc.nextInt();

        //만들어야 할 수
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(n, m, arr));
    }

    static int solution(int n, int m, int[] arr) {
        int count = 0, sum = 0, lt = 0;

        //rt 포인터가 맨 끝까지 반복
        for (int rt = 0; rt < n; rt++) {
            //처음부터 오른쪽으로 한칸씩 이동하며 더한 후 조건 값과 동일한지 확인 -> 조건 값과 일치해지면 lt 값 1증가
            //lt 값 1 증가후 기존에 위치해 있던 값을 뺀 후 1 이동후 위치 값을 더하기
            //그리고 값 검증 -> 값보다 크다면 lt 1 증가후 반복 / 값 보다 작다면 rt 증가
            // sum > m -> lt 증가 / sum == m -> lt 증가 / sum < m -> rt 증가  ==> 더한 값이 같거나 크면 lt++
            sum += arr[rt];
            if (sum == m) count++;
            while (sum >= m) {    //sum이 조건 값보다 크거나 같을 때
                sum -= arr[lt++];
                if (sum == m) count++;
            }
        }

        return count;
    }
}
