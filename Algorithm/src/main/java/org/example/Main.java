package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Solution7 Test - 프로그래머스 카운트 업
        Solution solution = new Solution();
        int start = 3;
        int end = 10;
        int[] result = solution.solution7(start, end);
        for (int num : result) {
            System.out.print(num + " ");
        }


        // Solution6 Test - 프로그래머스 문자열의 앞의 n글자
//        Solution solution = new Solution();
//        String my_string = "banana";
//        int n = 3;
//        String result = solution.solution6(my_string, n);
//        System.out.println("result = " + result);

        // Solution5 Test - 프로그래머스 카운트 다운
//        Solution solution = new Solution();
//        int start = 30;
//        int end = 15;
//        int[] result = solution.solution5(start, end);
//        System.out.println("Result:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

        // Solution4 Test - 프로그래머스 접두사인지 확인하기
//        Solution solution = new Solution();
//        String my_string = "hello";
//        String is_prefix = "he";
//        int result = solution.solution4(my_string, is_prefix);
//        System.out.println(result);

        // Solution3 Test - 프로그래머스 배열 만들기
//        Solution solution = new Solution();
//        int n = 20;
//        int k = 3;
//        List<Integer> result = solution.solution3(n, k); // solution 메소드 호출
//        System.out.println("Result:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

        // Solution2 Test - 프로그래머스 첫 번째로 나오는 음수
//        Solution solution = new Solution();
//        int[] num_list = {2, 1, -6, 4, 5};
//        int result = solution.solution2(num_list);
//        System.out.println("Result:" + result);

        // Solution1 Test - 프로그래머스 n 번째 원소부터
//        Solution solution = new Solution();
//        int[] num_list = {1, 2, 3, 4, 5};
//        int n = num_list.length;
//        int[] result = solution.solution1(num_list, n);
//        System.out.println("Result:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

    }
}
