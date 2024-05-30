package org.example;

public class Solution {
    public int[] solution1(int[] num_list, int n) {
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = num_list[i];
        }
        return answer;
    }

    public int solution2(int[] num_list) {
        int answer = -1;
        for(int i = 0; i<num_list.length;i++){
            if(num_list[i]<0){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
