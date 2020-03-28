package question0484_find_permutation;

/**
 * 递归地思考问题。
 *
 * 对于字符串s前面开始的n个连续的I，选择使用1, 2, 3, ..., n的排列的字典序是最小的。
 *
 * 对于字符串s前面开始的n个连续的D，选择使用n, n - 1, n - 2, ..., 1的排列的字典序是最小的。
 *
 * 已经考虑了前n个字符，接着s中考虑n + 1之后的字符，这时候就是递归的思想了，只不过起点数字不再是从1开始，而是从n + 1开始。
 *
 * 时间复杂度是O(s.length())。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败89.80%。消耗内存：41.8MB，击败25.00%。
 */
public class Solution {
    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j + 1) == 'D') {
                    j++;
                }
                for (int k = 0; k <= ((j - i) >> 1); k++) {
                    int tmp = result[k + i];
                    result[k + i] = result[j + 1 - k];
                    result[j + 1 - k] = tmp;
                }
                i = j;
            }
        }
        return result;
    }
}