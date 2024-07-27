package 알고리즘_강의.stackandqueue.queue.응급실;

import java.util.*;

/*
[설명]
메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다
    • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
    • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
현재 N명의 환자가 대기목록에 있습니다.
N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.

[입력]
첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.

[출력]
M번째 환자의 몇 번째로 진료받는지 출력하세요.

[예시 입력 1]
5 2
60 50 70 80 90

[예시 출력 1]
3

[예시 입력 2]
6 3
70 60 90 60 60 60

[예시 출력 2]
4
*/

// Queue 에 Person 객체가 아닌 환자의 번호와 위험도를 담고 있는 Map<Integer, Integer> 을 큐(Queue)에 넣으려고 했으나
// 위험도를 가져오기 위해 Map의 KeySet()으로 반복문을 한번 더 돌려야하는 번거로움이 있기 때문에
// Person 클래스를 생성하여 위험도(priority) 필드에 직접 접근하여 반복문을 한번을 제외할 수 있어 시간 복잡도가 줄어든다...
class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        //환자의 위험도를 저장할 배열
        int[] arr = new int[n];

        //값 주입
        for (int i = 0; i< n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(n, m, arr));
    }

    static int solution(int n, int m, int[] arr) {
        int result = 0;
        Queue<Person> queue = new ArrayDeque<>();

        //Queue에 환자 번호와 환자 우선순위를 담은 Person 객체 저장
        for (int i = 0; i < n; i++) {
            Person person = new Person(i, arr[i]);
            queue.offer(person);
        }

        while (true) {
            Person poll = queue.poll();
            for (Person p : queue) {
                if (poll.priority < p.priority) { //현재 환자보다 뒤에 있는 환자가 더 위험도가 높다면 현재 환자를 맨 뒤로 넣는다.
                    queue.offer(poll);
                    poll = null; //현재 환자는 비어 있다는 뜻
                    break;
                }
            }

            if (poll != null) { //현재 환자가 제일 위험도가 높다는 뜻
                result++;
                if (poll.id == m) //현재 치료받은 환자가 입력값으로 들어온 환자 번호와 동일하면 종료
                    break;
            }
        }

        return result;
    }
}
