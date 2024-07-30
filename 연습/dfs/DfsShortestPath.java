package 알고리즘_강의.연습.dfs;

class Node2 {
    int data;
    Node2 lt, rt;

    Node2(int data) {
        this.data = data;
    }
}

public class DfsShortestPath {
    Node2 root;
    public static void main(String[] args) {
        //데이터를 담아준다.
        DfsShortestPath main = new DfsShortestPath();
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

        //DFS 메소드를 호출한다.
        System.out.println(DFS(0, main.root));
    }

    static int DFS(int L, Node2 root) {
        if (root.lt == null && root.rt == null) return L; //현재 노드에서 왼/오른쪽 노드가 없다는 것은 현재 노드가 말단 노드.
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }
}
