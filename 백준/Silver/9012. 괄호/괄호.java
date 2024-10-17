import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String ps = br.readLine();

            if (isValid(ps)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }
        System.out.println(sb.toString());
    }

    public static Boolean isValid(String ps) {
        Stack<Integer> stack = new Stack<>();

        for (int j = 0; j < ps.length(); j++) {
            if (ps.charAt(j) == '(') {
                stack.push(j);
            } else if (ps.charAt(j) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
