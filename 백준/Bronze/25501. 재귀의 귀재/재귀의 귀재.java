import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            result.append(isPalindrome(s)).append("\n");
        }
        System.out.println(result.toString());
    }

    public static int recursion(String s, int l, int r){
        count.incrementAndGet();
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static String isPalindrome(String s){
        count.set(0);
        int result = recursion(s, 0, s.length() - 1);
        return result + " " + count.get();
    }
}