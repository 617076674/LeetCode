package question1491_average_salary_excluding_the_minimum_and_maximum_salary;

public class Solution {

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
        for (int num : salary) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            sum += num;
        }
        return (sum - max - min) * 1.0 / (salary.length - 2);
    }

}