package question1176_diet_plan_performance;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为calories数组的长度。
 *
 * 执行用时：2ms，击败94.50%。消耗内存：46.6MB，击败50.00%。
 */
public class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n;
        if (null == calories || (n = calories.length) == 0) {
            return 0;
        }
        int[] sum = new int[n];   //sum[i] = calories[0] + ... + calories[i]
        sum[0] = calories[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + calories[i];
        }
        int result = 0;
        for (int i = 0; i <= n - k; i++) {
            int total = sum[i + k - 1];
            if (i > 0) {
                total -= sum[i - 1];
            }
            if (total > upper) {
                result++;
            } else if (total < lower) {
                result--;
            }
        }
        return result;
    }
}