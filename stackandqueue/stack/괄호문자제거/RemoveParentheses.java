package 알고리즘_강의.stackandqueue.stack.괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

[출력]
남은 문자만 출력한다.

[예시 입력 1]
(A(BC)D)EF(G(H)(IJ)K)LM(N)

[예시 출력 1]
EFLM
 */
public class RemoveParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solution(str));

    }

    // 닫힌 괄호가 나온 다면 stack 에 열린 괄호가 나오기 전까지 값을 제거 한다.
    static String solution(String str) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            //열린 괄호가 나올때까지 pop() 진행 후 반복이 종료 되었다면 마지막 요소가 '(' 이라는 것이기 때문에 마지막에도 pop() 실행 으로 열린 괄호 '(' 를 제거 해준다.
            if (c == ')') {
                while (!stack.peek().equals('('))
                    stack.pop();
                stack.pop();
            } else stack.push(c); // ')' 가 아니라면 stack 에 값 추가(push)
        }

        for (Character c : stack)
            result += c;

        return result;
    }
}
