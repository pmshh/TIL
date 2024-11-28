package algorithm.problems.level0;

public class OrderCostCalculator  {
    public int solution(int n, int k) {
        int labmCost = 12000;
        int drinkCost = 2000;
        int freeDrinks = n / 10;
        return (labmCost * n) + (drinkCost * k) - (drinkCost * freeDrinks);
    }
}
