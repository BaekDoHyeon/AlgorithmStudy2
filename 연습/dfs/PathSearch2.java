package 알고리즘_강의.연습.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/*
    경로 탐색(인접 리스트)
    방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램 작성

    [입력]
    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5

    [출력]
    6
 */
public class PathSearch2 {

    static int[] arr;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int endNode;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        endNode = sc.nextInt(); // 정점 끝
        int e = sc.nextInt(); // 간선 수

        for (int i = 0; i <= endNode; i++)
            list.add(new ArrayList<>());

        //값 넣어주기...
        for (int i = 1; i <= e; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list.get(n1).add(n2); // n1 -> n2 이동 가능
        }

        arr = new int[endNode+1];
        arr[1] = 1;
        System.out.println(1);
    }

    static void DFS(int n) {
        if (n == endNode) count++;
        else {
            for (int i : list.get(n)) {
                if (arr[i] == 0) { //해당 위치에 체크가 되어있지 않다면...
                    arr[i] = 1;
                    DFS(i);
                    arr[i] = 0;
                }
            }
        }
    } //DFS 종료
}
