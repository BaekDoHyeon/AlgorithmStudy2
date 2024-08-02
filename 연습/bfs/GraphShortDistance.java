package 알고리즘_강의.연습.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

   [입력]
    6 9
    1 3
    1 4
    2 1
    2 5
    3 4
    4 5
    4 6
    6 2
    6 5

   [출력]
   2: 3
   3: 1
   4: 1
   5: 2
   6: 2
 */
// ========== 배열을 사용하여 문제풀이!!@! ==========
public class GraphShortDistance {

    static int n, m;
    static int[] ch, dis;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];
        dis = new int[n+1];

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            graph.get(num1).add(num2);
        }

        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + ": " + dis[i]);
        }
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        ch[n] = 1;
        dis[n] = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int i : graph.get(cur)) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dis[i] = dis[cur] + 1; //이동 거리를 1씩 증가..
                    queue.offer(i);
                }
            }
        }
    }
}
