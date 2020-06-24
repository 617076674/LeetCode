package question0964_least_operators_to_express_number;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(target)。
 *
 * 执行用时：4ms，击败68.57%。消耗内存：37.4MB，击败33.33%。
 */
public class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int leastOpsExpressTarget(int x, int target) {
        if (target <= x) {
            return Math.min((x - target) * 2, target * 2 - 1);
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int left = (int) (Math.log(target) / Math.log(x));
        if (Math.pow(x, left) == target) {
            return left - 1;
        }
        int right = left + 1, back = (int) (Math.pow(x, right) - target), forward = (int) (target - Math.pow(x, left));
        if (back < target) {
            memo.put(target, Math.min(right + leastOpsExpressTarget(x, back), left + leastOpsExpressTarget(x, forward)));
        } else {
            memo.put(target, left + leastOpsExpressTarget(x, forward));
        }
        return memo.get(target);
    }
}