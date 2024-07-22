package 알고리즘_강의.twopointers.공통원소구하기;

import java.util.*;

//답은 제대로 나오는 거 같으나 메모리 초과로 실패...
public class commonElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> resultList = new ArrayList<>();

        //입력
        int size1 = sc.nextInt();
        int[] arr = new int[100000001];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            list.set(num, 1);
//            arr[num]++;
        }

        int size2 = sc.nextInt();
        for(int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            arr[num]++;
        }

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 2) resultList.add(i);

        Collections.sort(resultList);
        for (int i : resultList)
            System.out.print(i + " ");

    }
}
