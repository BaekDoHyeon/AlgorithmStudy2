package 알고리즘_강의.stackandqueue.stack.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.

[입력]
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.

[출력]
첫 번째 줄에 YES, NO를 출력한다.

[예시 입력 1]
(()(()))(()

[예시 출력 1]
NO
 */
public class CorrectParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //괄호 입력
        String str = sc.next();

        System.out.println(solution(str));
    }

    static String solution(String str) {
        String result = "YES";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // 열린 괄호면 push()
            if (c == '(') stack.push(c);

            /*
                닫힌 괄호 일때는 pop()으로 열린괄호를 하나 제거해준다. (열린/닫힌 괄호는 한 쌍이기 때문에...)
                1) stack이 비어있지 않다면 pop() 진행
                2) 만약 stack의 값이 비어있다면 ( 닫힌 괄호가 열린괄호 보다 더 많이 있다는 뜻 -> 올바르지 않다. ) NO 출력
             */
            if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else result = "NO";
            }
        }

        //만약 반복문을 다 돌고난 후에 stack 이 비어있지 않다면 NO 출력 -> 열린 괄호 '(' 가 닫힌 괄호 보다 개수가 많기 때문에 올바르지 않다고 할 수 있다.
        if (!stack.isEmpty()) result = "NO";

        return result;
    }
}
