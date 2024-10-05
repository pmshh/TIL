package algorithm.problems.level0;

import java.util.Arrays;

public class TopAfterRemovingBottomFive {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int n = 5;
        int[] answer = new int[num_list.length-n];
        for(int i=n; i<num_list.length; i++){
            answer[i-n]=num_list[i];
        }

        return answer;
    }
}
