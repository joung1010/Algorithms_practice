import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numArr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr.add(Integer.parseInt(st.nextToken()));
        }

        Integer min = numArr.stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is not Empty"));

        Integer max = numArr.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is not Empty"));

        System.out.println(min + " " + max);
    }
}
