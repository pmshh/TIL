package algorithm.solution;

import java.util.Arrays;

public class ElementFromNth {

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];

        for (int i = n - 1; i < num_list.length; i++) {
            answer[i - n + 1] = num_list[i];
        }

        return answer;
    }

//    public int[] solution(int[] num_list, int n) {
//        int[] answer = new int[num_list.length - n + 1];
//
//        answer = Arrays.copyOfRange(num_list, n - 1, num_list.length);
//
//        return answer;
//    }
}
