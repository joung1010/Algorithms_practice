import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 음수 처리를 위해 오프셋 50 사용: visited[a+50][b+50][c+50]
    public static int[][][] visited = new int[101][101][101];  // 크기만 수정
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] nums = line.split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            int num3 = Integer.parseInt(nums[2]);

            // 종료 조건 추가
            if (num1 == -1 && num2 == -1 && num3 == -1) {
                break;
            }

            int result = w(num1, num2, num3);
            String print = "w(%d, %d, %d) = %d".formatted(num1, num2, num3, result);
            sb.append(print).append("\n");
        }

        System.out.print(sb);  // println 제거 (중복 개행 방지)
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 메모이제이션 확인 (오프셋 50 적용) 음수 처리
        if (visited[a + 50][b + 50][c + 50] != 0) {
            return visited[a + 50][b + 50][c + 50];
        }

        int result;
        if (a < b && b < c) {  // && 수정
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        // 메모이제이션 저장
        visited[a + 50][b + 50][c + 50] = result;
        return result;
    }
}

