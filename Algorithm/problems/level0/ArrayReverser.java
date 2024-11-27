package algorithm.problems.level0;

public class ArrayReverser {
    public int[] solution(int[] num_list) {
        int[] copy = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++) {
            copy[i] = num_list[num_list.length - 1 - i];
        }

        return copy;
    }
}
