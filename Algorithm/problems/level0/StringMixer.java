package algorithm.problems.level0;

public class StringMixer {
    public String solution(String str1, String str2) {
        String answer = "";
        for(int i = 0; i < str1.length(); i++){
            answer += String.valueOf(str1.charAt(i)) + str2.charAt(i);
        }

        return answer;
    }
}
