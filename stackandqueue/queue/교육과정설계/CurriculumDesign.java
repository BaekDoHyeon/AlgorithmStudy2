package 알고리즘_강의.stackandqueue.queue.교육과정설계;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
[설명]
현수는 1년 과정의 수업계획을 짜야 합니다.
수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.(수업설계의 길이는 30이하이다)

[출력]
첫 줄에 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력합니다.

[예시 입력 1]
CBA
CBDAGE

[예시 출력 1]
YES
 */

public class CurriculumDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //필수 과목
        String conStr = sc.next();

        //현수가 신청한 수강 과목
        String str = sc.next();

        System.out.println(solution(conStr, str));
    }

    static String solution(String conStr, String str) {
        String result = "YES";

        // 필수과목을 저장하고 있는 Queue 선언
        Queue<Character> conQueue = new ArrayDeque<>();

        for (Character c : conStr.toCharArray())
            conQueue.offer(c);

        for (int i = 0; i < str.length(); i++) {
            // 수강 신청한 과목이 필수 과목에 포함은 되어 있으나 우선 순위가 처음이 아닌 뒤에 순서 라면... -> NO 리턴..
            if (conQueue.contains(str.charAt(i)) && str.charAt(i) != conQueue.peek())
                return "NO";

            if (conQueue.contains(str.charAt(i)) && str.charAt(i) == conQueue.peek())
                conQueue.poll();
        }

        //수강 신청 과목을 다 돌았으나 필수 과목 Queue가 비어있지 않다면 -> 필수 과목을 듣지 않았다는 것이므로 NO 리턴..
        if (!conQueue.isEmpty()) return "NO";

        return result;
    }
}
