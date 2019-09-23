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
    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 0);
        map.put(1, 1);
    }

    public int fib(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        int result = fib(N - 1) + fib(N - 2);
        map.put(N, result);
        return result;
    }
}
