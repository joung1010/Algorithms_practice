import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Integer MAX_SIZE = 5;
    public static Integer MID_IDX = MAX_SIZE/2;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int [] arr = new int[MAX_SIZE];
        int sum = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        System.out.println(sum/MAX_SIZE);

        Arrays.sort(arr);
        System.out.println(arr[MID_IDX]);
    }
}