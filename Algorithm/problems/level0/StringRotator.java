package algorithm.problems.level0;

import java.util.Scanner;

public class StringRotator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        for(int i = 0; i<a.length(); i++) {
            System.out.println(a.charAt(i));
        }
    }
}
