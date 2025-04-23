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

        selected = new int[M];  // M개의 숫자를 선택할 배열
        resolve(0, 1);

        System.out.println(sb);
    }

    public static void resolve(int depth, int start) {
        if (depth == M) {
            //  자연수 중에서 중복 없이 M개를 고른 수열
            for (int i = 0; i < M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            resolve(depth + 1, i + 1);
        }

    }

}