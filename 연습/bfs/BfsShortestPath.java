package 알고리즘_강의.연습.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 lt, rt;

    Node2(int data) {
        this.data = data;
    }
}

public class BfsShortestPath {
    Node2 root;

    public static void main(String[] args) {
        //데이터를 담아준다.
        BfsShortestPath main = new BfsShortestPath();
        main.root = new Node2(1);
        main.root.lt = new Node2(2);
        main.root.rt = new Node2(3);
        main.root.lt.lt = new Node2(4);
        main.root.lt.rt = new Node2(5);
        main.root.rt.lt = new Node2(6);
        main.root.rt.rt = new Node2(7);
        main.root.lt.lt.lt = new Node2(8);
        main.root.lt.lt.rt = new Node2(9);
        main.root.lt.rt.lt = new Node2(8);
        main.root.lt.rt.rt = new Node2(9);

        System.out.println(BFS(main.root));
    }

    static int BFS(Node2 root) {
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);
        int Level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node2 cur = queue.poll();

                if (cur.lt == null && cur.rt == null) return Level;
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            Level++;
        }

        return 0;
    }
}
