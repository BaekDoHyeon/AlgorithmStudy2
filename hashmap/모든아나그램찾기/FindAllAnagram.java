package 알고리즘_강의.hashmap.모든아나그램찾기;
/*
[설명]
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

[입력]
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

[출력]
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

[예시 입력 1]
bacaAacba
abc

[예시 출력 1]
3

[힌트] - 출력 설명
{bac}, {acb}, {cba} 3개의 부분문자열이 "abc" 문자열과 아나그램입니다.
 */
import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String target = sc.next();

        System.out.println(solution(input, target));
    }

    static int solution(String input, String target) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> inputMap = new HashMap<>();

        int count = 0, lt = 0;

        //target 값 put
        for (Character c : target.toCharArray())
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);

        //target 값 - 1 만큼만 input 문자열 put
        for (int rt = 0; rt < target.length() -1; rt++)
            inputMap.put(input.charAt(rt), inputMap.getOrDefault(input.charAt(rt), 0) + 1);

        // rt 값 하나 증가시킨 후 target 과 값 비교 -> 일치하다면 count++, 일치하지 않는다면 lt에 위치에 있는값 지우고 반복 시작
        // 일치하든 일치하지 않든 lt에 위치에 있는 값 지우고 1증가 후 반복
        for (int rt = target.length() - 1; rt < input.length(); rt++) {
            inputMap.put(input.charAt(rt), inputMap.getOrDefault(input.charAt(rt), 0) + 1);

            if (inputMap.equals(targetMap)) count++;

            if(inputMap.get(input.charAt(lt)) == 1)
                inputMap.remove(input.charAt(lt));
            else
                inputMap.put(input.charAt(lt), inputMap.get(input.charAt(lt)) - 1);

            lt++;
        }
        return count;
    }
}
