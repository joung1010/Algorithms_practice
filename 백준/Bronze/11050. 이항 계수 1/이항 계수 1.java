import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        //         이항계수 n!/k!(n-k)!
        if (K == 0) {
            System.out.println("1");
            return;
        }

        int num = N - K;
        int result1 = N;
        for (int i = N - 1; i > num; i--) {
            result1 *= i;
        }

        int result2 = K;
        for (int i = K - 1; i > 0; i--) {
            result2 *= i;
        }

        System.out.println(result1 / result2);
    }
}