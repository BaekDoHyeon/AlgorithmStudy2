package 알고리즘_강의.twopointers.두배열합치기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeTwoArr {

    //투 포인터 방식을 사용 하지 않음...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int arr1Size = sc.nextInt();
        for (int i = 0; i < arr1Size; i++)
            list1.add(sc.nextInt());

        int arr2Size = sc.nextInt();
        for (int i = 0; i < arr2Size; i++)
            list2.add(sc.nextInt());

        //두 배열을 새로운 하나의 결과 배열에 몽땅 넣어 버린 후 sort(오름차순) 진행...
        resultList.addAll(list1);
        resultList.addAll(list2);
        Collections.sort(resultList);

        for (Integer i : resultList)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}
