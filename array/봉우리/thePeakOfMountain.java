package 알고리즘_강의.array.봉우리;

import java.util.Scanner;

public class thePeakOfMountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 입력 5
        int[][] arr = new int[n + 2][n + 2]; //맨 위, 맨 아래, 양 옆을 0으로 초기화하기 위해 행과 열을 +2 해주었음
        int count = 0; //봉우리 개수

        //격자판에 값 입력 5*5
        for (int i = 1; i <= n; i++) { //5행
            for (int j = 1; j <= n; j++) { //5열
                arr[i][j] = sc.nextInt();
            }
        }

        //위, 아래, 왼쪽, 오른쪽 값들보다 커야 봉우리가 된다.
        for (int i = 1; i <= n; i++) { //5행
            for (int j = 1; j <= n; j++) { //5열
                if(thePeakOfMountainCondition(arr, i, j))
                    count++;
            }
        }
        //봉우리 개수 출력
        System.out.println(count);
    }

    static boolean thePeakOfMountainCondition(int[][] arr, int i, int j) {
        if ((arr[i][j] > arr[i-1][j]) && (arr[i][j] > arr[i+1][j]) && (arr[i][j] > arr[i][j-1]) && (arr[i][j] > arr[i][j+1]))
            return true;
        return false;
    }
}
