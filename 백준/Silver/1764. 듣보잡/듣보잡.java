import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] target = br.readLine().split(" ");
        int N = Integer.parseInt(target[0]);
        int M = Integer.parseInt(target[1]);

        Set<String> noHear = new HashSet<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            noHear.add(name);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (noHear.contains(name)) {
                resultList.add(name);
            }
        }

        Collections.sort(resultList);

        StringBuilder sb = new StringBuilder();
        sb.append(resultList.size()).append("\n");
        for (String name : resultList) {
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());
    }
}
