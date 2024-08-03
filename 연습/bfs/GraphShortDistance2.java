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
// ========== Level을 사용하여 문제풀이!!@! ==========
public class GraphShortDistance2 {

    static int n, m, level;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            graph.get(num1).add(num2);
        }

        BFS(1);
    }

    static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        ch[n] = 1;
        queue.offer(n);
        System.out.println(level++ + ": " + n);

        while (!queue.isEmpty()) {
            System.out.print(level + ": ");
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                Integer cur = queue.poll();
                for (int num : graph.get(cur)) {
                    if (ch[num] == 0) {
                        ch[num] = 1;
                        queue.offer(num);
                        System.out.print(num + " ");
                    }
                }
            }
            System.out.println();
            level++;
        }
    }
}
