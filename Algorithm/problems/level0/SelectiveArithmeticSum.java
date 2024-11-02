package algorithm.problems.level0;

public class SelectiveArithmeticSum {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += a + (i * d);
                continue;
            }
        }

        return answer;
    }
}
