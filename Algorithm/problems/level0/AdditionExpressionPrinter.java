package algorithm.problems.level0;

import java.util.Scanner;

public class AdditionExpressionPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int answer = a + b;

        System.out.println(a + " + " + b + " = " + answer);
    }
}
