import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 자료구조 개수

        int[] typeArr = new int[N]; // 자료구조 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각각 자료구조의 개수만큼 어떠한 자료구조를 가지는지 입력받기(큐 or 스택)
        for (int i = 0; i < N; i++) {
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>(); // 단일 Deque 사용

        st = new StringTokenizer(br.readLine());
        // 각각의 자료구조가 가지는 값 입력받기(하나의 원소밖에 가지지 못함)
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (typeArr[i] == 0) { 
                // 큐(0)인 경우만 저장, 스택(1)은 값이 바로 제거되므로 저장 필요 없음
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 삽입할 수열의 길이

        st = new StringTokenizer(br.readLine());
        br.close();
        
        // 삽입 수열 처리
        while (M-- > 0) {
            int moveValue = Integer.parseInt(st.nextToken());
            // 새 값을 맨 앞에 추가하고, 맨 뒤 값을 제거해 결과로 사용
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" "); 
        }

        // 최종 결과 출력
        System.out.println(sb);
    }
}
