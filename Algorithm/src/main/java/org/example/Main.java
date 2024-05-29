package org.example;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num_list = {1, 2, 3, 4, 5};
        int n = num_list.length;
        int[] result = solution.solution(num_list, n);
        System.out.println("Result:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
