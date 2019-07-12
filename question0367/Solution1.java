package question0367;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 用一个集合记录int类型范围内的所有完全平方数。
 *
 * 时间复杂度和空间复杂度均是O(Integer.MAX_VALUE ^ 0.5)。
 *
 * 执行用时：274ms，击败13.75%。消耗内存：97.4MB，击败5.13%。
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        Set<Integer> set = new HashSet<>();
        for (long i = 1; i * i < Integer.MAX_VALUE; i++) {
            set.add((int) (i * i));
        }
        return set.contains(num);
    }
}
