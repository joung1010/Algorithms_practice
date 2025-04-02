import java.io.*;
import java.util.*;


public class Main {


//    자주 나오는 단어일수록 앞에 배치한다.
//    해당 단어의 길이가 길수록 앞에 배치한다.
//    알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> words = new ArrayList<>();
        for (String word : map.keySet()) {
            if (word.length() >= M) {
                words.add(word);
            }
        }
        words.sort((a, b) -> {
            int freqCompare = map.get(b) - map.get(a);
            if (freqCompare != 0) {
                return freqCompare;
            }
            int lenCompare = b.length() - a.length();
            if (lenCompare != 0) {
                return lenCompare;
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }


}