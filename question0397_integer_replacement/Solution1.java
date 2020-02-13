package question0397_integer_replacement;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 因为Integer.MAX_VALUE + 1会越界，所以递归函数要用long型变量。
 *
 * 时间复杂度是O(n)。空间复杂度是O(logn)。
 *
 * 执行用时：1ms，击败58.84%。消耗内存：38.2MB，击败5.69%。
 */
public class Solution1 {
    private Map<Long, Integer> memory = new HashMap<>();

    public int integerReplacement(int n) {
        return integerReplacement((long) n);
    }

    private int integerReplacement(long num) {
        if (memory.containsKey(num)) {
            return memory.get(num);
        }
        if (num == 1) {
            return 0;
        }
        if ((num & 1) == 0) {
            int result = 1 + integerReplacement(num >> 1);
            memory.put(num, result);
            return result;
        }
        int result = Math.min(integerReplacement(num + 1), integerReplacement(num - 1)) + 1;
        memory.put(num, result);
        return result;
    }
}