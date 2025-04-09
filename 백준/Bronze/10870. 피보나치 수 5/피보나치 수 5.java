import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = resolve(0, 1, n);
        System.out.println(result);

    }

    public static int resolve(int previous, int current, int count) {
        if (count == 0) {
            return previous;
        }

        return resolve(current, current + previous, count - 1);
    }

}