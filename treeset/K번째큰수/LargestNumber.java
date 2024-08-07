package 알고리즘_강의.treeset.K번째큰수;
/*
[설명]
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.

[입력]
첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.

[출력]
첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.

[예시 입력 1 ]
10 3
13 15 34 23 45 65 33 11 26 42

[예시 출력 1]
143
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(n, k, arr));

    }

    static int solution(int n, int k, int[] arr) {
        int count = 0, sum = 0, result = -1;

        // set은 중복값이 들어갈 수 없다.
        // Collections.reverseOrder() 는 내림차순으로 정렬해준다. -> set의 기본정렬은 오름차순 -> 해당 메소드를 지워주면 알아서 오름차순으로 된다.
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

        //3장을 뽑을 수 있는 모든 경우의 수 더하기..
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int l = j + 1; l < n; l++)
                    tree.add(arr[i] + arr[j] + arr[l]);

        for (int i : tree) {
            count++;
            if (count == k) return i;
        }

        return result;
    }
}
