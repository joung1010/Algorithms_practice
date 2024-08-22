import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        List<int[]> positionList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            positionList.add(arr);
        }

        Collections.sort(positionList
                , (o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                });

        for (int[] pos : positionList) {
            System.out.println(pos[0] + " " + pos[1]);
        }
    }
}