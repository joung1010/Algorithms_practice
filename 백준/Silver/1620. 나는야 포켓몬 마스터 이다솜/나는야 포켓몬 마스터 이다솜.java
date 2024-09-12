import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        Integer N = Integer.parseInt(input[0]);
        Integer M = Integer.parseInt(input[1]);

        Map<String,Integer> pocketMapFindByName = new HashMap<>();
        Map<Integer,String> pocketMapFindByCode = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pocketMon = br.readLine();
            pocketMapFindByName.put(pocketMon,i);
            pocketMapFindByCode.put(i,pocketMon);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (isNumberQuiz(quiz)) {
                sb.append(pocketMapFindByCode.get(Integer.parseInt(quiz))).append("\n");
            } else {
                sb.append(pocketMapFindByName.get(quiz)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static Boolean isNumberQuiz(String quiz) {
        return quiz.matches("\\d+");
    }
}
