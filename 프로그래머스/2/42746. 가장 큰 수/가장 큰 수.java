import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String solution(int[] numbers) {
        List<String> numbersStrList = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        Collections.sort(numbersStrList, (o1, o2) -> {
            String strNum1 = o1 + o2;
            String strNum2 = o2 + o1;
            return strNum2.compareTo(strNum1);
        });

        if (numbersStrList.get(0).equals("0")) {
            return "0";
        }

        return String.join("", numbersStrList);
    }
}