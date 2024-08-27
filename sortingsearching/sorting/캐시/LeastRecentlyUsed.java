package 알고리즘_강의.sortingsearching.sorting.캐시;

import java.util.Scanner;

/*
README.md 참고...

[입력]
첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.

[출력]
마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.

[예시 입력]
5 9
1 2 3 2 6 2 3 5 7

[예시 출력]
7 5 3 2 6
 */
public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cache = new int[n];
        int[] cacheTmp = new int[m];

        for (int i = 0; i < m; i++)
            cacheTmp[i] = sc.nextInt();

        //현재 들어온 숫자가 cache 에 존재 하는지 확인..
            //존재 한다면 해당 숫자부터 앞으로 한칸씩 댕기고 해당 숫자는 맨 처음에 삽입
            //존재하지 않는다면 마지막 숫자부터 한칸씩 앞으로 댕긴다. -> 만약 마지막 숫자가 현재 인덱스의 마지막에 존재한다면 제거

        //m 번만큼 반복...
        for (int num : cacheTmp) {

            boolean sameNum = false;
            int idx = n;

            //해당 숫자가 존재하는지 확인.
            for (int i = 0; i < n; i++) {
                if (cache[i] == num) {
                    sameNum = true;
                    idx = i;
                    break;
                } else if (cache[i] == 0)
                    break;
            }

            //존재 한다면
            if (sameNum) {
                int tmp = cache[idx];
                for (int j = idx; j > 0; j--)
                    cache[j] = cache[j-1];
                cache[0] = tmp;
            } else { //존재하지 않는다면
                for (int j = n-2; j >= 0; j--)
                    cache[j+1] = cache[j];
                cache[0] = num;
            }
        }

        for (int i : cache)
            System.out.print(i + " ");
    }
}