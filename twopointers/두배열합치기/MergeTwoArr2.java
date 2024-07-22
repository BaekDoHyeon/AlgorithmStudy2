package 알고리즘_강의.twopointers.두배열합치기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoArr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //첫 번째 배열의 크기와 해당 크기 만큼의 배열 선언
        int size1 = sc.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++)
            arr1[i] = sc.nextInt();

        //두 번째 배열의 크기와 해당 크기 만큼의 배열 선언
        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++)
            arr2[i] = sc.nextInt();

         for(Integer i : solution(size1, size2, arr1, arr2)) {
             System.out.print(i + " ");
         }
    }

    static List<Integer> solution(int s1, int s2, int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        //배열들을 가리킬 포인터1, 포인터2 선언
        int p1 = 0;
        int p2 = 0;

        //두 배열중 하나가 끝에 다다르면 반복을 종료
        while (p1 < s1 && p2 < s2) {
            //두 번째 배열의 숫자가 더 크다면 첫 번째 배열의 숫자를 넣고 포인터를 1 증가
            if (arr1[p1] < arr2[p2]) resultList.add(arr1[p1++]);
            else resultList.add(arr2[p2++]);
        }

        //아직 끝나지 않는 배열의 값들을 결과 리스트에 저장
        while (p1 < s1) resultList.add(arr1[p1++]);
        while (p2 < s2) resultList.add(arr2[p2++]);

        return resultList;
    }
}
