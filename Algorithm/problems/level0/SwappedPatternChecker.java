package algorithm.problems.level0;

public class SwappedPatternChecker {
    public int solution(String myString, String pat) {
        int answer = 0;

        String replacedStr = myString.replace('A', 'C').replace('B', 'A').replace('C', 'B');

        if (replacedStr.contains(pat)) {
            answer = 1;
        }

        return answer;
    }
}
