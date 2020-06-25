package question0982_triples_with_bitwise_and_equal_to_zero;

/**
 * 先进行预处理，计算得到 count 数组，其中 count[i] 表示能和 i 相与，使其结果为 0 的数组 A 中的元素个数。
 *
 * 时间复杂度是 O(max(n ^ 2, n * (2 ^ 16)))。空间复杂度是 O(2 ^ 16)。
 *
 * 执行用时：8ms，击败92.68%。消耗内存：39.2MB，击败66.67%。
 */
public class Solution2 {
    public int countTriplets(int[] A) {
        int[] count = new int[1 << 16];
        for (int num : A) {
            // 如果 tmp 变量的二进制表示形式为 10001，其为 1 的地方就是 num 以二进制表示时 0 所在的位置
            int tmp = num ^ (((1 << 16) - 1)), i = tmp;
            while (i > 0) {
                count[i]++;
                // 用 (i - 1) & tmp 罗列出所有能与 num 相与结果为 0 的所有 i
                i = (i - 1) & tmp;
            }
            count[0]++;
        }
        int result = 0;
        for (int num1 : A) {
            for (int num2 : A) {
                result += count[num1 & num2];
            }
        }
        return result;
    }
}