package org.example;

public class Main {
    public static void main(String[] args) {
        // Solution1 Test
//        Solution solution = new Solution();
//        int[] num_list = {1, 2, 3, 4, 5};
//        int n = num_list.length;
//        int[] result = solution.solution1(num_list, n);
//        System.out.println("Result:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

        // Solution2 Test
        Solution solution = new Solution();
        int[] num_list = {2, 1, -6, 4, 5};
        int result = solution.solution2(num_list);

        System.out.println("Result:" + result);
    }
}
