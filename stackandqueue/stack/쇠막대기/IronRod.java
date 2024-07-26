package 알고리즘_강의.stackandqueue.stack.쇠막대기;

import java.util.Scanner;
import java.util.Stack;

// 문제가 쪼~금 길긴해서 README.md 파일 작성 및 참고
public class IronRod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //괄호를 입력받는다.
        String str = sc.next();

        System.out.println(solution(str));
    }

    //()(((()())(())()))(())
    //(((()(()()))(())()))(()())
    static int solution(String str) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') stack.push(arr[i]);
            else if (arr[i] == ')') {
                if (arr[i-1] == '(') {
                    stack.pop();
                    result += stack.size();
                } else if (arr[i-1] == ')') {
                    stack.pop();
                    result++;
                }
            }
        }

        return result;
    }
}
