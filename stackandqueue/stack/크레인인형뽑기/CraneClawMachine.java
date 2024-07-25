package 알고리즘_강의.stackandqueue.stack.크레인인형뽑기;

import java.util.Scanner;
import java.util.Stack;

// 문제가 길기 때문에 README.md 필요...
// 출력 : 첫 줄에 터트려져 사라진 인형의 개수를 출력합니다.
public class CraneClawMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //인형뽑기 격자판 배열
        int[][] board = new int[n][n];

        //배열 값 입력
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        //크레인 이동 횟수
        int moveCnt = sc.nextInt();

        //이동 위치를 담는 배열
        int[] moves = new int[moveCnt];

        //크레인 이동 위치 입력
        for (int i = 0; i < moveCnt; i++)
            moves[i] = sc.nextInt();

        System.out.println(solution(n, board, moveCnt, moves));

    }

    static int solution(int n, int[][] board, int moveCnt, int[] moves) {
        //터트린 인형의 개수.. -> 똑같은 인형 2개가 연달아 붙어있다면 터지기 때문에 한번 터질때마다 2씩 증가...
        int count = 0;

        //뽑은 인형을 담을 Stack 선언
        Stack<Integer> stack = new Stack<>();

        //크레인의 위치는 열(Column)을 의미 (move-1 해야함)
        for (int move : moves) {    // move 는 열의 위치
            for (int i = 0; i < n; i++) {  //행 한칸씩 증가
                if (board[i][move-1] == 0) continue;
                else { // 0이 아니라면 -> 인형이 있다면...
                    if (!stack.isEmpty()) { // 현재 스택에 값이 비어 있다면,,
                        if (stack.peek() == board[i][move-1]) { //인형이 서로 중첩되어 터트려야한다.
                            stack.pop();
                            count += 2; //인형이 터지면 2개가 없어진것이기 때문에 count 에 2 를 더한다.
                        } else { //마지막 인형과 다른 인형이라면 stack 에 해당 인형 번호를 push() 한다.
                            stack.push(board[i][move - 1]);
                        }
                    } else stack.push(board[i][move - 1]); // 현재 스택에 값이 비어 있지 않다면 stack 에 값을 푸시

                    board[i][move-1] = 0; // 해당 인형이 있던 자리 값은 0으로 변경
                }
                break;
            }
        }

        return count;
    }
}
