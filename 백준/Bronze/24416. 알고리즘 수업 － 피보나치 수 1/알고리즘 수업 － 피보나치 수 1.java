import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int CODE1 = 0;
    public static int CODE2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fib(N);
        fibonacci(N);

        System.out.println(CODE1 + " " + CODE2);
    }


    public static int fib (int N) {
        if (N == 1 || N == 2) {
            CODE1++;
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }


    public static int fibonacci(int N) {
        int[] f = new int[N + 1]; // 1-indexed 배열
        f[1] = f[2] = 1; // 기본 케이스 초기화

        for (int i = 3; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2]; // 점화식 계산
            CODE2++; // 코드2 실행 횟수 증가
        }

        return f[N];
    }
}
