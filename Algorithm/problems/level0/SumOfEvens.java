package algorithm.problems.level0;

public class SumOfEvens {
    public int solution(int n) {
        // 짝수인지 확인 후 가장 큰 짝수까지 계산
        int maxEven = (n % 2 == 0) ? n : n - 1;
        // 짝수의 개수 계산
        int count = maxEven / 2;
        // 짝수의 합 계산 (등차수열 합 공식: n * (첫항 + 마지막항) / 2)
        return count * (2 + maxEven) / 2;
    }
}
