package algorithm.problems.level0;

public class DivisionMultiplier {
    public int solution(int num1, int num2) {
        double answer = (double) num1 / num2 * 1000;
        return (int)answer;
    }
}
