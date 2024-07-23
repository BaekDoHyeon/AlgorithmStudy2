package 알고리즘_강의.hashmap.아나그램;
/*
[설명]
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

[입력]
첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
단어의 길이는 100을 넘지 않습니다.

[출력]
두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.

[예시 입력 1]
AbaAeCe
baeeACA

[예시 출력 1]
YES

[예시 입력 2]
abaCC
Caaab

[예시 출력 2]
NO
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(solution(str1, str2));
    }

    static String solution(String str1, String str2) {
        String result = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : str1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        /*
            아나 그램(Anagram)이 될 수 없는 조건
            1) map 에 들어 있는 key 외에 다른 키가 존재 하는 경우...
            2) map 의 key 에 해당 하는 값이 0보다 작아 지려고 하는 경우.. (알파벳 숫자가 맞지 않다는 뜻)
         */
        for (Character c : str2.toCharArray()) {
            //str2 에 존재 하는 key가 map 에는 존재 하지 않거나, 해당 키의 값이 0이라면.. -> 0이라는 것은 알파벳의 개수가 다르다는 뜻
            //문제 조건 에서 입력 받은 두 문자열은 길이가 같다고 한다.
            if (!map.containsKey(c) || map.get(c) == 0) return "NO";

            //해당 key의 값을 1 감소
            map.put(c, map.get(c) - 1);
        }

        return result;
    }
}