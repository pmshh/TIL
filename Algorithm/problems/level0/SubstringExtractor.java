package algorithm.solution;

public class SubstringExtractor {

    public String solution(String my_string, int n) {
        String answer = "";
        answer = my_string.substring(my_string.length() - n);
        return answer;
    }
}
