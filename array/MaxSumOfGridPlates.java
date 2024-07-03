package 알고리즘_강의.array;

import java.util.Scanner;

public class MaxSumOfGridPlates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] array = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                array[i][j] = in.nextInt();
        }

        System.out.println(solution(n, array));
    }

    private static int solution(int input, int[][] array) {
        int sum1 = 0; //가로 합을 저장 하는 변수 및 정방향(?) 대각선 합
        int sum2 = 0; //세로 합을 저장 하는 변수 및 역방향(?) 대각선 합
        int maxResult = 0;

        //가로, 세로 더하기 위한 반복문
        for(int i = 0; i < input; i++) {
            for(int j=0; j < input; j++) {
                sum1 += array[i][j];
                sum2 += array[j][i];
            }
            int tmpMax = Math.max(sum1, sum2);
            maxResult = Math.max(maxResult, tmpMax);
            sum1 = sum2 = 0;
        }

        //대각선 합을 위한 반복문
        for (int i = 0; i < input; i++) {
            sum1 += array[i][i];
            sum2 += array[input-1-i][i];
        }
        int tmpMax = Math.max(sum1, sum2);
        maxResult = Math.max(maxResult, tmpMax);

        return maxResult;
    }
}
