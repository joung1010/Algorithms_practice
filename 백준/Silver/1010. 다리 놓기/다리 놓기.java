import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            Integer result = resolve(x, y);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static Integer resolve
            (int x, int y) {

        if (x == y) {
            return 1;
        }
        int num = y - x;

        BigInteger result1 = BigInteger.valueOf(y);
        for (int i = y - 1; i > num; i--) {
            result1 = result1.multiply(BigInteger.valueOf(i));
        }

        BigInteger result2 = BigInteger.valueOf(x);
        for (int i = x - 1; i > 0; i--) {
            result2 = result2.multiply(BigInteger.valueOf(i));
        }

        return result1.divide(result2).intValue();
    }
}