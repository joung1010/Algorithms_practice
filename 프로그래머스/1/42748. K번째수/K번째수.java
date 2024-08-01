class Solution {
public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            final int str = command[0] - 1;
            final int end = command[1] - 1;
            final int target = command[2] - 1;

            int tmpIdx = 0;
            int[] sortArr = new int[end - str + 1];
            for (int i = str; i <= end; i++) {
                sortArr[tmpIdx++] = array[i];
            }

            int length = sortArr.length;
            for (int j = 0; j < length; j++) {
                int minIdx = j;
                for (int k = j + 1; k < length; k++) {
                    if (sortArr[k] < sortArr[minIdx]) {
                        minIdx = k;
                    }
                }
                int tmp = sortArr[minIdx];
                sortArr[minIdx] = sortArr[j];
                sortArr[j] = tmp;
            }
            answer[idx++] = sortArr[target];

        }


        return answer;
    }
}