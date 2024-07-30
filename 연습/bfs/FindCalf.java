package 알고리즘_강의.연습.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
8. 송아지 찾기 1(BFS : 상태트리탐색)

[설명]
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

[출력]
점프의 최소 횟수를 구한다. 답은 1 이상이며 반드시 존재 합니다.

[예시 입력 1]
5 14

[예시 출력 1]
3
 */
public class FindCalf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); //현재 현수의 위치
        int e = sc.nextInt(); //송아지의 위치

        System.out.println(BPS(s, e));

    }

    static int BPS(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        int Level = 0;
        int[] move = new int[] {1, -1, 5};
        int[] ch = new int[10001]; //한번 갔던 위치는 체크 해놓기 위해 최대 입력값인 10,000만큼의 배열 선언
        ch[s] = 1; // s 인덱스의 값이 1이라면 지나온 길(이미 나온 값)이라고 체크한다. 체크를 확인해서 나왔던 숫자라면 큐에 넣지 않기 위해!
        queue.offer(s);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer cur = queue.poll();
                for (int j = 0; j < move.length; j++) {
                    int tmp = cur + move[j];

                    if (tmp == e) return Level + 1;

                    if (tmp >= 1 && tmp <= 10000 && ch[tmp] == 0) {
                        ch[tmp] = 1;
                        queue.offer(tmp);
                    }
                }
            }
            Level++;
        }
        return Level;
    }
}
