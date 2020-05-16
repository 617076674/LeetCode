package question1058_minimize_rounding_error_to_meet_target;

import java.util.Arrays;

/**
 * 所有的数字都能向下取整，但不一定能向上取整。如 20.000 就只能向下取整为 20，不能向上取整为 21。
 *
 * 时间复杂度是 O(nlogn)，其中 n 为数组 prices 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：8ms，击败92.31%。消耗内存：40.4MB，击败50.00%。
 */
public class Solution {
    public String minimizeError(String[] prices, int target) {
        int min = 0, canCeil = 0;
        double[] decimals = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (!prices[i].substring(prices[i].length() - 3).equals("000")) {
                canCeil++;
            }
            int integer = Integer.parseInt(prices[i].substring(0, prices[i].length() - 4));
            min += integer;
            decimals[i] = Double.parseDouble(prices[i]) - integer;
        }
        if (target < min || target > min + canCeil) {
            return "-1";
        }
        int numOfCeil = target - min;
        Arrays.sort(decimals);
        double result = 0.0;
        for (int i = decimals.length - 1; i >= 0; i--) {
            if (decimals.length - i <= numOfCeil) {
                result += 1 - decimals[i];
            } else {
                result += decimals[i];
            }
        }
        return String.format("%.3f", result);
    }
}