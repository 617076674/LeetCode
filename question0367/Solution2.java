package question0367;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 观察规律：1，4，9，16，25，……
 *
 * 这些完全平方数的间隔分别为3，5，7，9，……
 *
 * 时间复杂度是(num ^ 0.5)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败42.73%。消耗内存：33.3MB，击败11.05%。
 */
public class Solution2 {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
