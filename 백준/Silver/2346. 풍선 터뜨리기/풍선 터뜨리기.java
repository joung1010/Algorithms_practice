import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] pick = br.readLine().split(" ");

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.add(new int[]{i + 1, Integer.parseInt(pick[i])}); // [풍선 번호, 이동 값]
        }

        StringJoiner joiner = new StringJoiner(" ");

        int[] current = deque.pollFirst();
        joiner.add(String.valueOf(current[0]));

        while (!deque.isEmpty()) {
            int move = current[1]; // 이동할 거리

            // 양수와 음수에 따라 deque를 회전
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst()); // 오른쪽 이동
                }
                current = deque.pollFirst(); // 다음 터뜨릴 풍선
            } else {
                for (int i = 0; i < Math.abs(move) - 1; i++) {
                    deque.addFirst(deque.pollLast()); // 왼쪽 이동
                }
                current = deque.pollLast(); // 다음 터뜨릴 풍선
            }

            joiner.add(String.valueOf(current[0])); // 터진 풍선 번호 추가
        }

        System.out.println(joiner.toString());
    }
}