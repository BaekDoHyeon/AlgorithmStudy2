package 알고리즘_강의.stackandqueue.stack.후위식연산;

import java.util.Scanner;
import java.util.Stack;

/*
[설명]
후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

[입력]
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

[출력]
연산한 결과를 출력합니다.

[예시 입력 1]
352+*9-

[예시 출력 1]
12
 */
public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solution(str));
    }

    static int solution(String str) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) stack.push(Integer.parseInt(String.valueOf(c)));
            else { // 숫자가 아닌 연산이라면... 숫자 두개를 뺀 후 연산 진행
                int num1, num2, tmp;
                num2 = stack.pop();
                num1 = stack.pop();

                //식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
                switch (c) {
                    case '+':
                        tmp = num1 + num2;
                        stack.push(tmp);
                        break;
                    case '-':
                        tmp = num1 - num2;
                        stack.push(tmp);
                        break;
                    case '*':
                        tmp = num1 * num2;
                        stack.push(tmp);
                        break;
                    case '/':
                        tmp = num1 / num2;
                        stack.push(tmp);
                        break;
                }
            }
        }

        //스택에 존재하는 마지막 값(최종 연산값)을 리턴..
        result = stack.pop();

        return result;
    }
}
