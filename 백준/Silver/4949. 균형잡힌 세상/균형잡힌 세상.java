import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            if (isValid(line)) {

                sb.append("yes")
                        .append("\n");
            } else {

                sb.append("no")
                        .append("\n");
            }

        }
        System.out.println(sb.toString());

    }

    public static boolean isValid(String lines) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < lines.length(); i++) {
            char ch = lines.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {

                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }

                stack.pop();
            } else if (ch == ']') {

                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }

                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}
