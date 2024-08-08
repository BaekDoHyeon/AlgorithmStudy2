package 알고리즘_강의.dfsbfs.dfs.바둑이승차;

import java.util.Scanner;

/*
[설명]
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
둘째 줄부터 N마리 바둑이의 무게가 주어진다.

[출력]
첫 번째 줄에 가장 무거운 무게를 출력한다.

[예시 입력 1]
259 5
81
58
42
33
61

[예시 출력 1]
242
 */
public class Main {

    static int maxValue, n, result = 0;
    static int[] arr, ch;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //트럭에 태울 수 있는 최대 무게
        maxValue = sc.nextInt();

        //바둑이 수
        n = sc.nextInt();

        //바둑이의 무게를 저장해놓는 배열 선언
        arr = new int[n];

        //탑승한 바둑이 체크 배열
        ch = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = 0;
        DFS(0, sum);
        System.out.println(result);
    }

    static void DFS(int l, int sum) {
        if (sum > maxValue) return; // 합이 최대 무게수보다 높아지면 종료
        if (l == n) {
            result = Math.max(sum, result);
        } else {
            DFS(l+1, sum + arr[l]);
            DFS(l+1, sum);
        }
    }
}
