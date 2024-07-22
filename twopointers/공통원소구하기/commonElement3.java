package 알고리즘_강의.twopointers.공통원소구하기;

import java.util.*;

// 챗 지피티의 도움을 받은 코드
public class commonElement3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 첫 번째 배열 입력
        int size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            set1.add(num);
        }

        // 두 번째 배열 입력
        int size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            set2.add(num);
        }

        // 첫 번째 Set과 두 번째 Set의 교집합 구하기
        set1.retainAll(set2);

        // 정렬 및 출력
        List<Integer> resultList = new ArrayList<>(set1);
        Collections.sort(resultList);

        for (int num : resultList) {
            System.out.print(num + " ");
        }
    }
}
