package 알고리즘_강의.array.임시반장정하기;

import java.util.Scanner;

public class anInterimLeader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentCnt = sc.nextInt();

        int[][] arr = new int[studentCnt][5]; //행은 학생수, 컬럼 수는 5개(5학년)
        int[] countArr = new int[studentCnt]; //인덱스 번호는 학생번호-1 -> 내부 값은 해당학생이 같은반을 해본 학생 수
        int max = 0;
        int maxIndex = 1;

        //입력
        for(int i = 0; i < studentCnt; i++) {
            for (int j = 0; j < 5; j++)
                arr[i][j] = sc.nextInt();
        }

        //학생 수만큼 반복 -> 마지막 학생은 더이상 뒤에있는 학생이 없으므로 student -1 까지만 반복 한다.
        for (int i = 0; i < studentCnt-1; i++) {
            //학생 수만큼 반복 -> 각 학년 마다의 반을 조회하기 위해 -> 조회는 마지막 학생까지 해야하므로 studentCnt 전까지 돌린다.
            for (int j = i+1; j < studentCnt; j++) {
                //각 학생마다 5학년 까지 있으므로 5번 반복 -> 열(컬럼)을 의미
                for (int k = 0; k < 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        countArr[i]++;
                        countArr[j]++;
                        break;
                    }
                }
            }
        }

        //제일 많이 같은 반을 해본 학생을 구하는 로직
        //만약 한명도 같은 반이 된적이 없다면 첫 번째 학생(1번 학생)이 임시 반장 선정
        for (int i = 0; i < studentCnt; i++) {
            if (countArr[i] > max) {
                max = countArr[i];
                maxIndex = i+1;
            }
        }

        System.out.println(maxIndex);
    }
}
