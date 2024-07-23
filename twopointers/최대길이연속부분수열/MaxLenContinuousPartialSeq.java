package 알고리즘_강의.twopointers.최대길이연속부분수열;

import java.util.Scanner;

/*
[설명]
0과 1로 구성된 길이가 N인 수열이 주어집니다.
여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1
여러분이 만들 수 있는 1이 연속된 연속부분수열은
1 1 1 1 1 1 1 1
이며 그 길이는 8입니다.

[입력]
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

[출력]
첫 줄에 최대 길이를 출력하세요.

[예시 입력 1]
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

[예시 출력 1]
8
 */
public class MaxLenContinuousPartialSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        //수열 입력
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(n, k, arr));
    }

    static int solution(int n, int k, int[] arr) {
        //cnt : 0을 1로 바꾼 카운트
        int result = 0, cnt = 0, lt = 0;

        //만약 cnt > k 라면 lt를 0이 존재했던 위치로 이동후 1을 다시 0으로 변경 cnt--;
        //result = rt - lt + 1; -> 만약 rt - lt + 1 의 값이 result 의 값보다 크면 그때 값 주입
        for (int rt = 0; rt < n; rt++) {
            //현재 rt 포인터의 위치 값이 0 이라면 cnt++ 후 1로 변경
            if (arr[rt] == 0) cnt++;

            //lt 포인터를 기존의 0이였던 인덱스까지 이동
            while (cnt > k) {
                if (arr[lt] == 0) cnt--;
                //현재 인덱스 값이 0이 아니든, 0이든 어차피 lt 값 증가는 동일..
                lt++;
            }
            // 왼/오른쪽 포인터 사이의 값이 (1이 연속된 수열) 이전에 저장된 수열 값보다 크면, 현재 값을 결과 변수에 저장
            int tmp = rt - lt + 1;
            if(tmp > result) result = tmp;
        }
        return result;
    }

}
