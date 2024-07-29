package 알고리즘_강의.연습.bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    Node(int data) {
        this.data = data;
    }
}

public class BfsMain {
    Node root;

    public static void main(String[] args) {
        //데이터를 담아준다.
        BfsMain main = new BfsMain();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);

        BFS(main.root);
    }

    static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int Level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(Level + ": ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            Level++;
            System.out.println();
        }
    }
}
