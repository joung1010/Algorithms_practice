import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> emoji = new HashSet<String>();
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String chat = br.readLine();
            if(ENTER.equals(chat)) {
                emoji.clear();
                continue;
            }
            
            if(!emoji.contains(chat)) {
                count++;
                emoji.add(chat);
            }
            
        }

        System.out.println(count);

    }


}