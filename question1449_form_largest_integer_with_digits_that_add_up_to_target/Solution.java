package question1449_form_largest_integer_with_digits_that_add_up_to_target;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(target)。
 *
 * 执行用时：54ms，击败71.05%。消耗内存：62.3MB，击败48.28%。
 */
public class Solution {

    private static final String UNSET = "unset";

    private String[] memo;

    public String largestNumber(int[] cost, int target) {
        memo = new String[target + 1];
        Arrays.fill(memo, UNSET);
        String result = largestNumberHelper(cost, target);
        return null == result ? "0" : result;
    }

    private String largestNumberHelper(int[] cost, int target) {
        if (target == 0) {
            return "";
        }
        if (!UNSET.equals(memo[target])) {
            return memo[target];
        }
        String result = null;
        for (int i = 0; i < cost.length; i++) {
            if (target >= cost[i]) {
                String tmp = largestNumberHelper(cost, target - cost[i]);
                if (null != tmp) {
                    tmp = (i + 1) + tmp;
                    if (null == result || tmp.length() > result.length() || (tmp.length() == result.length() && tmp.compareTo(result) > 0)) {
                        result = tmp;
                    }
                }
            }
        }
        memo[target] = result;
        return result;
    }

}