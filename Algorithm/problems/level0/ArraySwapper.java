package algorithm.problems.level0;

public class ArraySwapper {
    public int[] solution(int[] arr, int[][] queries) {
        int temp = 0;
        for(int i =0; i<queries.length; i++){
            temp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp;
        }
        return arr;
    }
}
