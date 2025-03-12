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
            Integer x = Integer.parseInt(line[0]);
            Integer y = Integer.parseInt(line[1]);
            Integer result = resolve(x, y);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static Integer resolve(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        }
        BigInteger x = BigInteger.valueOf(num1);
        BigInteger y = BigInteger.valueOf(num2);

        BigInteger num = y.subtract(x);

        BigInteger result1 = BigInteger.ONE;
        for (int i = y.intValue(); i > num.intValue(); i--) {
            result1 = result1.multiply(BigInteger.valueOf(i));
        }

        BigInteger result2 = BigInteger.ONE;
        for (int i = x.intValue(); i > 0; i--) {
            result2 = result2.multiply(BigInteger.valueOf(i));
        }

        return result1.divide(result2).intValue();
    }
}