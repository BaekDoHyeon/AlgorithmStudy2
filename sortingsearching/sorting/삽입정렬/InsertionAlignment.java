package 알고리즘_강의.sortingsearching.sorting.삽입정렬;

import java.util.Scanner;

/*
[설명]
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
정렬하는 방법은 선택정렬입니다.

[입력]
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.

[출력]
오름차순으로 정렬된 수열을 출력합니다.

[예시 입력]
6
13 5 11 7 23 15

[예시 출력]
5 7 11 13 15 23
*/
public class InsertionAlignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        //값 입력
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 1; i < n; i ++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }

        for (int i : arr)
            System.out.print(i + " ");
    }
}
