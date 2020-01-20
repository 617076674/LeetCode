package question0318_maximum_product_of_word_lengths;

/**
 * 位运算。
 *
 * 将words数组中的每一个字符串转换为一个数字，如果出现a，则该数字与1或运算，如果出现b，则该数字与2或运算……
 *
 * 时间复杂度是O(n ^ 2)，其中n为words数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败100.00%。消耗内存：38.7MB，击败94.59%。
 */
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }
        return result;
    }
}