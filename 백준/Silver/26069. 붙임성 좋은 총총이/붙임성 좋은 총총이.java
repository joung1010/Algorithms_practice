import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final String NAME_CHONG = "ChongChong";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            
            Set<String> dance = new HashSet<>();
            dance.add(NAME_CHONG);
            
            for (int i = 0; i < N; i++) {
                String[] people = br.readLine().split(" ");
                String personA = people[0];
                String personB = people[1];
                
                if (dance.contains(personA) || dance.contains(personB)) {
                    dance.add(personA);
                    dance.add(personB);
                }
            }
            System.out.println(dance.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}