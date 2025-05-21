import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private static int N;
    private static int[] numbers;
    private static int[] operatorCounts; // +, -, *, / 각각의 개수
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 입력
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        operatorCounts = new int[4];
        for (int i = 0; i < 4; i++) {
            operatorCounts[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]); // 첫 번째 숫자부터 시작

        // 결과 출력
        System.out.println(max);
        System.out.println(min);
    }


    private static void dfs(int depth, int result) {
        // 모든 숫자를 다 사용했을 때
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // 각 연산자 시도
        for (int i = 0; i < 4; i++) {
            if (operatorCounts[i] > 0) {// 연산 방문처리
                // 연산자 사용
                operatorCounts[i]--;

                // 연산 수행
                int nextResult = calculateResult(result, numbers[depth], i);

                // 다음 숫자 처리
                dfs(depth + 1, nextResult);

                // 연산자 복원 (백트래킹)
                operatorCounts[i]++;
            }
        }
    }


    private static int calculateResult(int current, int next, int operator) {
        switch (operator) {
            case 0: return current + next; // 덧셈
            case 1: return current - next; // 뺄셈
            case 2: return current * next; // 곱셈
            case 3: return current / next; // 나눗셈
            default: return 0;
        }
    }

}