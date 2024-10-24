import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수
        int n = Integer.parseInt(br.readLine());

        // 줄을 선 학생 번호 입력
        String[] input = br.readLine().split(" ");
        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> waiting = new Stack<>();

        // 학생 번호를 Queue에 저장
        for (int i = 0; i < n; i++) {
            line.offer(Integer.parseInt(input[i]));
        }

        int next = 1; // 간식 배부 순서대로 번호
        while (!line.isEmpty()) {
            if (line.peek() == next) {
                line.poll(); // 순서가 맞으면 줄에서 간식을 받고 나감
                next++;
            } else {
                // 기다리는 줄에서 처리 가능한지 확인
                if (!waiting.isEmpty() && waiting.peek() == next) {
                    waiting.pop(); // 기다리는 줄에서 순서가 맞으면 나감
                    next++;
                } else {
                    // 그렇지 않으면 대기줄에 줄을 선 학생을 이동
                    waiting.push(line.poll());
                }
            }
        }

        // 줄이 다 비었을 때, 대기 줄도 확인해야 함
        while (!waiting.isEmpty()) {
            if (waiting.peek() == next) {
                waiting.pop(); // 대기줄에서 처리
                next++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");

    }

}
