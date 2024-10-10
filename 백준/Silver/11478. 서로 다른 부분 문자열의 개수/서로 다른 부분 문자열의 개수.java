import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String input = br.readLine();
        int length = input.length();
        // 총 부분 문자열의 개수 계산
//        int totalSubstrings = length * (length + 1) / 2;

        
        // 중복 제거
        Set<String> uniqueSubstrings = new HashSet<>();
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                uniqueSubstrings.add(input.substring(i, j));
            }
        }

        // 부분 문자열의 총 개수 출력
        System.out.println(uniqueSubstrings.size());

    }
}
