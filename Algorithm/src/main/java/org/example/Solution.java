package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> solution3(int n, int k) {
        List<Integer> answer = new ArrayList<>();

        for (int i=1; k*i<=n; i++) {
            answer.add(k*i);
        }
        return answer;
    }

    public int solution4(String my_string, String is_prefix) {
        int answer = 0;
        if(my_string.startsWith(is_prefix)){
            answer = 1;
        }
        return answer;
    }
}
