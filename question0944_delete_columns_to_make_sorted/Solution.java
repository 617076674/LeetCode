package question0944_delete_columns_to_make_sorted;

/**
 * 时间复杂度是O(m * n)，其中m是数组A的长度，n是数组A中字符串的长度。空间复杂度是O(1)。
 *
 * 执行用时：25ms，击败60.41%。消耗内存：38MB，击败94.62%。
 */
public class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < A.length; j++) {
                sb.append(A[j].charAt(i));
            }
            if (!isNonDecreasing(sb.toString())) {
                result++;
            }
        }
        return result;
    }

    private boolean isNonDecreasing(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) < s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
