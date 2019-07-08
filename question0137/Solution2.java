package question0137;

/**
 * 分析请见：https://blog.csdn.net/qq_41231926/article/details/85758627
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败72.89%。消耗内存：39.3MB，击败26.28%。
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int i = 0; i < nums.length; i++) {
            x2 ^= x1 & nums[i];
            x1 ^= nums[i];
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
