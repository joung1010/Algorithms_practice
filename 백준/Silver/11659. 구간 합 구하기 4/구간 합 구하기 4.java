import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] numbers = new long[N + 1];
        long[] sumsArr = new long[N + 1]; //sumsArr[0] = 0

        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
            sumsArr[i] = sumsArr[i - 1] + numbers[i];
        }

        for (int q = 0; q < M; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(sumsArr[j] - sumsArr[i - 1]);
        }
    }
}