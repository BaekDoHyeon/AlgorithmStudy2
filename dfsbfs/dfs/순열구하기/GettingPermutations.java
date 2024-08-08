package 알고리즘_강의.dfsbfs.dfs.순열구하기;

import java.util.Scanner;

/*
    [ 순열 구하기 ]
    10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력하라

    [입력 설명]
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
    두 번째 줄에 N개의 자연수가 오름차순로 주어집니다.

    [출력 설명]
    첫 번째 줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.

    [입력 예제]
    3 2
    3 6 9

    [출력 예제]
    3 6
    3 9
    6 3
    6 9
    9 3
    9 6
 */
public class GettingPermutations {

    static int[] arr, ch;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //자연수의 개수
        n = sc.nextInt();

        //수열에 나열할 수의 개수
        m = sc.nextInt();

        //자연수를 담을 배열
        arr = new int[n];
        ch = new int[n];
        int[] result = new int[m];

        //자연수 입력
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        DFS(0, result);

    }

    static void DFS(int cnt, int[] result) {
       if (cnt == m) {
           for (int i : result)
               System.out.print(i + " ");
           System.out.println();
       } else {
           for (int i = 0; i < n; i++) {
               //중복 되는 값 없이 수열에 값 추가
               if (ch[i] == 0) {
                   result[cnt] = arr[i];
                   ch[i] = 1;
                   DFS(cnt + 1, result);
                   ch[i] = 0; //위 호출이 끝나면 해당 숫자의 체크는 지운다.
               }
           } // for 종료
       } // else 종료
    } // DFS 종료
}
