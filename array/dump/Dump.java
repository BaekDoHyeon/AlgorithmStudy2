package 알고리즘_강의.array.dump;

import java.util.Scanner;

public class Dump {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int dumpCount = sc.nextInt();

        //인덱스에 높이 값을 입력한다.
        for(int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(dumpCount, arr));
    }

    private static int solution(int dumpCount, int[] arr) {
        int maxIndex = 0;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int result = 0;

        //dump 카운트 만큼 반복, 작업 시작
        for(int j = 1; j <= dumpCount; j++) {
            //배열 길이만큼 배열 순회
            for (int i = 0; i < arr.length; i++) {
                //if 문 2개를 분리 해둔 이유는 10개의 숫자가 오름차순으로 정렬 되어 있다면 min 에 값이 안 들어갈 수 있기 때문.
                if (arr[i] >= arr[maxIndex]) maxIndex = i;

                if (arr[i] <= arr[minIndex]) minIndex = i;
            }

            arr[maxIndex]--;
            arr[minIndex]++;
            maxIndex = 0;
            minIndex = 0;
        }

        //덤프가 다 끝난 후 로직 (최대값 - 최소값)
        for (int num : arr) {
            if (num > max) max = num;

            if (num < min) min = num;
        }

        result = max - min;

        return result;
    }
}
