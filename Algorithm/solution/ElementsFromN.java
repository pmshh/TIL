package org.solution;

public class ElementsFromN {

    public int[] solution1(int[] num_list, int n) {
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = num_list[i];
        }
        return answer;
    }

}
