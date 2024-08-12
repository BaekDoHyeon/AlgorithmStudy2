package 알고리즘_강의.dfsbfs.dfs.피자배달거리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// README.md 참고...
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PizzaDeliveryStreet {
    static int n, m;
    static int minStreet = Integer.MAX_VALUE;
    static int[][] board;
    static List<Point> houses = new ArrayList<>();
    static List<Point> pizzas = new ArrayList<>();
    static List<Point> selectPizzas = new ArrayList<>(); // m 개의 피자집이 들어갈 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n * n 의 격자판 생성
        n = sc.nextInt();

        // 선택할 피자집 개수 m
        m = sc.nextInt();

        board = new int[n][n];

        // 격자판에 값 입력 (0 : 빈칸, 1 : 집, 2: 피자 가게)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();

                //입력 받은 값이 1이면 집 배열, 2면 피자 가게 배열로 저장
                if (board[i][j] == 1)
                    houses.add(new Point(i,j));
                else if (board[i][j] == 2)
                    pizzas.add(new Point(i, j));
            }
        }

        //메인 로직
        DFS(0);

        System.out.println(minStreet);
    }

    // 0 부터 피자 가게(pizzas.size()) 개수 만큼 반복..
    static void DFS(int sIdx) {
        if (selectPizzas.size() == m) {
            //도시의 최소 배달거리 구하기 로직
            int totalSum = 0;
            for (Point house : houses) {
                int houseMin = Integer.MAX_VALUE;
                for (Point selectPizza : selectPizzas)
                    houseMin = Math.min(Math.abs(house.x - selectPizza.x) + Math.abs(house.y - selectPizza.y), houseMin);
                totalSum += houseMin;
            }
            minStreet = Math.min(totalSum, minStreet);
        } else {
            for (int i = sIdx; i < pizzas.size(); i++) {
                selectPizzas.add(pizzas.get(i));
                DFS(i + 1); // sIdx + 1 이 아닌 i + 1 로 해주어야 시간 초과가 나지 않는다..
                selectPizzas.remove(selectPizzas.size() - 1);
            }
        }
    } // DFS 종료
}
