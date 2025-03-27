import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int recordCount = Integer.parseInt(br.readLine());
            int greetingCount = 0;
            Set<String> greetedUsers = new HashSet<>();

            for (int i = 0; i < recordCount; i++) {
                String record = br.readLine();
                if (ENTER.equals(record)) {
                    greetedUsers.clear();
                } else if (greetedUsers.add(record)) {
                    greetingCount++;
                }
            }
            System.out.println(greetingCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}