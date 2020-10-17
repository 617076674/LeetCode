package question1553_minimum_number_of_days_to_eat_n_oranges;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(logn)。
 *
 * 执行用时：3ms，击败98.28%。消耗内存：38.2MB，击败35.56%。
 */
public class Solution {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        Integer result = memo.get(n);
        if (null != result) {
            return result;
        }
        result = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
        memo.put(n, result);
        return result;
    }

}