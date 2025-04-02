import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        산술평균 : N개의 수들의 합을 N으로 나눈 값
//        중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
//        최빈값 : N개의 수들 중 가장 많이 나타나는 값
//        범위 : N개의 수들 중 최댓값과 최솟값의 차이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int middleIndex = N / 2;


        int totalSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        Map<Integer, Integer> freq = new TreeMap();

        for (int i = 0; i < N; i++) {
            Integer number = Integer.parseInt(br.readLine());
            arr[i] = number;

            freq.put(number, freq.getOrDefault(number, 0) + 1);
            totalSum += number;
            if (min > number) {
                min = number;
            }
            if (max < number) {
                max = number;
            }

        }
        // 배열 정렬
        Arrays.sort(arr);

        // 1. 산술평균 (소수점 첫번째 자리에서 반올림)
        int mean = (int) Math.round((double) totalSum / N);

        // 2. 중앙값 : 정렬된 배열의 가운데 원소
        int median = arr[middleIndex];

        // 3. 최빈값 계산
        int maxFreq = Collections.max(freq.values());
        List<Integer> modeCandidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modeCandidates.add(entry.getKey());
            }
        }
        // 여러 개라면 두 번째로 작은 값을 선택, 아니면 유일한 값을 선택
        int mode = (modeCandidates.size() > 1) ? modeCandidates.get(1) : modeCandidates.get(0);

        // 4. 범위 계산: 최대값 - 최소값
        int range = max - min;

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(mean));
        bw.newLine();
        bw.write(String.valueOf(median));
        bw.newLine();
        bw.write(String.valueOf(mode));
        bw.newLine();
        bw.write(String.valueOf(range));
        bw.newLine();
        bw.flush();
        bw.close();

    }


}