package 알고리즘_강의.dfsbfs.dfs.수열추측하기;

import java.util.Scanner;

// README.md 참고
// 복습 필요한 내용... 나중에 기회가 된다면 한번 더 풀어보기...
public class SequenceGuess {

    //콤비네이션 저장 배열, 순열을 저장할 배열, 체크 배열
    static int[] combi, seq, ch;

    //콤비네이션 체크 배열
    static int[][] combiArr;
    static int n, f;
    static boolean exitFlag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가장 윗줄에 있는 숫자
        n = sc.nextInt();

        // 가장 밑에 나오는 숫자 (결과)
        f = sc.nextInt();

        combiArr = new int[n][n];
        seq = new int[n];
        ch = new int[n+1];

        //콤비네이션 값을 구한 후 배열에 저장
        combi = new int[n];
        for (int i = 0; i < n; i++)
            combi[i] = combi(n - 1, i);

        DFS(0, 0);
    }

    //콤비네이션을 구하는 공식 (메모이제이션..?)
    static int combi(int m, int i) {
        if (i == 0 || i == m) return 1;

        if (combiArr[m][i] == 0) return combi(m - 1, i - 1)  + combi(m - 1, i);
        else return combiArr[m][i];
    }

    static void DFS(int cnt, int sum) {
        if (exitFlag) return;
        if (sum > f) return;

        if (cnt == n) {
            if (sum == f)
                for (int i : seq) {
                    System.out.print(i + " ");
                    exitFlag = true;
                }

        } else { // DFS 가 종료되면 체크를 해주고 sum에서도 값을 빼주어야 올바른 값이 나온다.
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    seq[cnt] = i;
                    sum += combi[cnt] * seq[cnt];
                    ch[i] = 1;
                    DFS(cnt + 1, sum);
                    ch[i] = 0;
                    sum -= combi[cnt] * seq[cnt];
                }
            }
        }
    }
}
