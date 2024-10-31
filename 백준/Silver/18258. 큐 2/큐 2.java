import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        IntegerQueue queue = new IntegerQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            queue.executeCommand(br.readLine(), sb);
        }

        System.out.print(sb.toString());
    }

    static class IntegerQueue {
        private Queue<Integer> queue;
        private int backElement;

        public IntegerQueue() {
            this.queue = new LinkedList<>();
            this.backElement = -1;
        }

        public void executeCommand(String command, StringBuilder sb) {
            String[] str = command.split(" ");

            switch (str[0]) {
                case "push": {
                    int num = Integer.parseInt(str[1]);
                    queue.add(num);
                    backElement = num;
                    break;
                }
                case "pop": {
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    if (queue.isEmpty()) {
                        backElement = -1;
                    }
                    break;
                }
                case "size": {
                    sb.append(queue.size()).append('\n');
                    break;
                }
                case "empty": {
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                }
                case "front": {
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                }
                case "back": {
                    sb.append(queue.isEmpty() ? -1 : backElement).append('\n');
                    break;
                }
            }
        }
    }
}