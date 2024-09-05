import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        AtomicInteger index = new AtomicInteger(0);
        Map<Integer, Integer> compactPosition = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toMap(
                        item -> item
                        , itme -> index.getAndIncrement()
                ));

        StringBuilder sb = new StringBuilder();
        numbers.forEach(number -> sb.append(compactPosition.get(number)).append(" "));
        System.out.println(sb.toString().trim());

    }
}