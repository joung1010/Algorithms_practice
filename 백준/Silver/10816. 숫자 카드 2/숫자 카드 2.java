import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            cardMap.merge(cardNum, 1, Integer::sum);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int queryCardNum = Integer.parseInt(st.nextToken());
            int matchCardCount = cardMap.getOrDefault(queryCardNum, 0);
            sb.append(matchCardCount).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
