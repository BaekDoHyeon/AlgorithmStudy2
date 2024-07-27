package 알고리즘_강의.연습.dfs;

//이진트리 순회 - 부분 집합 구하기 연습!
public class Main2 {

    //조건은 3으로 준다. -> 3의 부분 집합을 구해라.
    static int number = 3;

    //부분집합에 포함되는 숫자값 인덱스에 1 혹은 0 을 넣기 위해 생성.. -> 1인덱스 값이 1이면 1을 포함, 0이면 1을 미포함 한다는 뜻
    static int[] arr = new int[number+1];

    public static void main(String[] args) {
        DFS(1);
    }

    static void DFS(int n) {
        //말단 노드
        if (n == number + 1) {
            //인덱스 확인 후 포함하는 숫자들 출력
            for (int i = 1; i < n; i++)
                if (arr[i] == 1)
                    System.out.print(i + " ");
            System.out.println();
            return;
        }

        arr[n] = 1; //n의 값을 포함 하고(1 설정) 왼쪽 노드 실행
        DFS(n+1); //왼쪽 노드 실행 (n 값을 포함 하는 노드)

        arr[n] = 0; //n의 값을 포함 하지 않고(0 설정) 오른쪽 노드 실행
        DFS(n+1); //오른쪽 노드 실행 (n 값을 포함 하지 않는 노드)
    }
}