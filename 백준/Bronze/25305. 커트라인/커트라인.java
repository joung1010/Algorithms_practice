import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int applicants = Integer.parseInt(st.nextToken());
        final int limit = Integer.parseInt(st.nextToken());

        Integer [] score = new Integer[applicants];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(score[limit - 1]);
    }
}
