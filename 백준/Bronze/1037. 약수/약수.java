import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int result = resolve(N, list);
        System.out.println(result);


    }

    public static Integer resolve(int n, List<Integer> list) {
        if (n == 1) {
            Integer item = list.get(0);
            return item * item;
        }

        return list.get(0) * list.get(n - 1);
    }

}