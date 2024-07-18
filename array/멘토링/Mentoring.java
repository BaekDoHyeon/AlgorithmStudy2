package 알고리즘_강의.array.멘토링;

import java.util.Scanner;

public class Mentoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentCnt = sc.nextInt();
        int forCnt = sc.nextInt();

        int[][] arr = new int[forCnt][studentCnt];
        int[][] studentArr = new int[studentCnt+1][studentCnt+1];
        int count = 0;

        //학생 수와 수학 테스트결과 입력
        for (int i = 0; i < forCnt; i++) {
            for (int j = 0; j < studentCnt; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < forCnt; i++) {
            for (int j = 0; j < studentCnt - 1; j++) {
                for (int k = j + 1; k < studentCnt; k++) {
                    studentArr[arr[i][j]][arr[i][k]]++;
                }
            }
        }

        for (int i = 1; i <= studentCnt; i++) {
            for (int j = 1; j <= studentCnt; j++)
                if (studentArr[i][j] == forCnt)
                    count++;
        }

        System.out.println(count);
    }
}
