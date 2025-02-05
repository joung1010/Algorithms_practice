import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // queuestack의 길이
        int N = Integer.parseInt(br.readLine());
        
        int result = N * (N - 1);
        System.out.println(result);
    }
}
