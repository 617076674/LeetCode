package question0201_bitwise_and_of_numbers_range;

/**
 * 求 m 和 n 的二进制表示法的公共前缀。
 *
 * 时间复杂度是 O(logn)。空间复杂度是 O(1)。
 *
 * 执行用时：7ms，击败39.69%。消耗内存：39.3MB，击败21.14%。
 */
public class Solution1 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}