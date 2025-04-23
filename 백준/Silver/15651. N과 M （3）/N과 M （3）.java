import java.io.*;


public class Main {

    private static int N;
    private static int M;

    private static int[] selected;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        selected = new int[M];
        resolve(0);

        System.out.println(sb);
    }

    public static void resolve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            resolve(depth + 1);
        }

    }

}