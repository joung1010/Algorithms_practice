import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 파일의 끝까지 입력 받기
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line);
            String result = generateCantor(n);
            System.out.println(result);
        }

    }

    public static String generateCantor(int n) {
        if (n == 0) {
            return "-";
        }

        // 이전 단계의 패턴 가져오기
        String prev = generateCantor(n - 1);

        // 가운데 공백 생성 (이전 패턴 길이와 동일)
        String empty = " ".repeat(prev.length());

        // 새 패턴 반환: 이전 패턴 + 공백 + 이전 패턴
        return prev + empty + prev;

//        N=0: -
//        N=1: - - (3개의 문자 중 가운데가 공백)
//        N=2: - -   - - (9개의 문자 중 가운데 3개가 공백, 그리고 남은 각 3개의 문자 중 가운데가 공백)
//        N=3: - -   - -         - -   - - (27개의 문자 중에서 패턴이 계속 적용됨)
    }


}