import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();

        Set<Integer> A = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        Set<Integer> B = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());


        Set<Integer> AminusB = new HashSet<>(A);
        AminusB.removeAll(B);

        Set<Integer> BminusA = new HashSet<>(B);
        BminusA.removeAll(A);

        System.out.println(AminusB.size() + BminusA.size());
    }
}
