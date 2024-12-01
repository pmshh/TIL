package algorithm.problems.level0;

public class CountEvenOdd {
    public int[] solution(int[] num_list) {
        int evenCount = 0;
        int oddCount = 0;
        for (int number : num_list) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return new int[] {evenCount, oddCount};
    }
}
