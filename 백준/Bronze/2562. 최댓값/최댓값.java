import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Integer MAX_SIZE = 9;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int maxNum = 0;
        int maxIndex = 0;

        for (int i = 1; i <= MAX_SIZE; i++) {
            int num = sc.nextInt();
            if (num > maxNum) {
                maxNum = num;
                maxIndex = i;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxIndex);
    }
}