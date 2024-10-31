import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        CustomDequeue customDequeue = new CustomDequeue();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            customDequeue.push(line.split(" "));
        }

        System.out.print(customDequeue.getResult());
    }

    static class CustomDequeue {
        private Deque<Integer> deque;
        private StringBuilder stringBuilder;

        public CustomDequeue() {
            deque = new ArrayDeque<>();
            stringBuilder = new StringBuilder();
        }

        public void push(String[] line) {
            String command = line[0];

            switch (command) {
                case "1":
                    // 앞에 넣기
                    int value1 = Integer.parseInt(line[1]);
                    deque.addFirst(value1);
                    break;
                case "2":
                    // 뒤에 넣기
                    int value2 = Integer.parseInt(line[1]);
                    deque.addLast(value2);
                    break;
                case "3":
                    // 앞에서 빼기
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    } else {
                        stringBuilder.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "4":
                    // 뒤에서 빼기
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    } else {
                        stringBuilder.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "5":
                    // 덱의 크기
                    stringBuilder.append(deque.size()).append("\n");
                    break;
                case "6":
                    // 비어있는지 확인
                    stringBuilder.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "7":
                    // 앞 요소 조회
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    } else {
                        stringBuilder.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "8":
                    // 뒤 요소 조회
                    if (deque.isEmpty()) {
                        stringBuilder.append("-1\n");
                    } else {
                        stringBuilder.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }

        public String getResult() {
            return stringBuilder.toString();
        }
    }
}
