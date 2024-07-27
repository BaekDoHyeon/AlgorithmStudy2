package 알고리즘_강의.연습.dfs;

class Node {
    int data;
    Node lt, rt;

    Node(int data) {
        this.data = data;
    }
}

//이진 트리 순회 연습!!! (DFS - Depth-First Search)
public class Main {
    Node root;

    public static void main(String[] args) {
        //데이터를 담아준다.
        Main main = new Main();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);

        //DFS 메소드를 호출한다.
        DFS(main.root);
    }

    static void DFS(Node root) {
        //말단 노드라면 return; -> 종료
        if (root == null) return;
        //System.out.print(root.data + " "); // 전위 순회
        DFS(root.lt);
        //System.out.print(root.data + " "); // 중위 순회
        DFS(root.rt);
        System.out.print(root.data + " "); // 후위 순회
    }
}
