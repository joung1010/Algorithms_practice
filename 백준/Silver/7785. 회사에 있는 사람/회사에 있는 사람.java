import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static final String WORKING = "enter";
    public static final String LEAVING = "leave";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer recordCount = Integer.parseInt(br.readLine());
        Set<String> workingSet = new HashSet<>();
        for (int i = 0; i < recordCount; i++) {
            String[] employee = br.readLine().split(" ");
            if(WORKING.equals(employee[1])) {
                workingSet.add(employee[0]);
            }else if(LEAVING.equals(employee[1])) {
                workingSet.remove(employee[0]);
            }
        }

        List<String> resultList = new ArrayList<>(workingSet);
        Collections.sort(resultList, Collections.reverseOrder());

        
        StringBuilder sb = new StringBuilder();
        for (String name : resultList) {
            sb.append(name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
