import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {


//    자주 나오는 단어일수록 앞에 배치한다.
//    해당 단어의 길이가 길수록 앞에 배치한다.
//    알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String result = map.keySet().stream()
                .filter(s -> s.length() >= M)
                .sorted(
                        Comparator.comparing((String s) -> map.get(s)).reversed()
                                .thenComparing(Comparator.comparing(String::length).reversed())
                                .thenComparing(Comparator.naturalOrder())
                )
                .collect(Collectors.joining("\n"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.flush();
        bw.close();
    }


}