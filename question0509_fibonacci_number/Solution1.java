package question0509_fibonacci_number;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划。
 *
 * 时间复杂度是O(N)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败64.20%。消耗内存：33.3MB，击败56.66%。
 */
public class Solution1 {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        int result = fib(N - 1) + fib(N - 2);
        memo.put(N, result);
        return result;
    }

}