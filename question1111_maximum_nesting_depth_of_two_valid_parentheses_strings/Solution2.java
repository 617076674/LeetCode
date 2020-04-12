package question1111_maximum_nesting_depth_of_two_valid_parentheses_strings;

/**
 * 数学。
 *
 * 对于索引为奇数的'('，其嵌套深度是偶数；对于索引为偶数的')'，其嵌套深度是偶数。
 *
 * 时间复杂度是O(n)，其中n为字符串seq的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败72.00%。消耗内存：40MB，击败7.14%。
 */
public class Solution2 {
    public int[] maxDepthAfterSplit(String seq) {
        int n;
        if (null == seq || (n = seq.length()) == 0) {
            return new int[0];
        }
        int[] result = new int[n];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if ((c == '(' && (i & 1) == 1) || (c == ')' && (i & 1) == 0)) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }
}