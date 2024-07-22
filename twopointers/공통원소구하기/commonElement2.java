package 알고리즘_강의.twopointers.공통원소구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
[설명]
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


[입력]
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.


[출력]
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

[예시 입력 1]
5
1 3 9 5 2
5
3 2 5 7 8

[예시 출력 1]
2 3 5

 */
public class commonElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++)
            arr1[i] = sc.nextInt();

        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++)
            arr2[i] = sc.nextInt();


        for(Integer i : solution(size1, size2, arr1, arr2)) {
            System.out.print(i + " ");
        }
    }

    static List<Integer> solution(int size1, int size2, int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        //입력 받은 배열들을 정렬한다.
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        //두 배열중 하나가 끝나면 종료
        while (p1 < size1 && p2 < size2) {
            if (arr1[p1] == arr2[p2]) {
                list.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) p1++; //arr1의 값이 더 작다면 포인터 1 증가
            else p2++;
        }

        return list;
    }
}
