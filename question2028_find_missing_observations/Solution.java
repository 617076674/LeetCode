package question2028_find_missing_observations;

public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int minSum = sum + n, maxSum = sum + n * 6, realSum = mean * (n + rolls.length);
        if (realSum < minSum || realSum > maxSum) {
            return new int[] {};
        }
        int[] result = new int[n];
        int gap = realSum - sum;
        int num = gap / n, index = gap % n;
        for (int i = 0; i < index; i++) {
            result[i] = num + 1;
        }
        for (int i = index; i < n; i++) {
            result[i] = num;
        }
        return result;
    }

}