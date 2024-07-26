package 알고리즘_강의.stackandqueue.queue.공주구하기;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// README.md 참고..
public class SavingPrincess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }

    static int solution(int n, int k) {
        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++)
            queue.offer(i);

        while (queue.size() != 1) {
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                if (i != k-1) {
                    Integer poll = queue.poll();
                    queue.offer(poll);
                } else queue.poll();
            }
        }

        return queue.poll();
    }

}
