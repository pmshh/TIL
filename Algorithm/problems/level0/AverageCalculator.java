package algorithm.problems.level0;

public class AverageCalculator {
    public double solution(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}
