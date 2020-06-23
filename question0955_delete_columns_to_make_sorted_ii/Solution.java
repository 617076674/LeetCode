package question0955_delete_columns_to_make_sorted_ii;

/**
 * 贪心算法。
 *
 * 不是看每一列可否删除，而是转换思路，看每一列可否保留。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为数组 A 的长度，n 为数组 A 中字符串的长度。
 *
 * 执行用时：7ms，击败40.97%。消耗内存：39.9MB，击败100.00%。
 */
public class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        StringBuilder[] stringBuilders = new StringBuilder[A.length];
        for (int i = 0; i < A.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        for (int j = 0; j < A[0].length(); j++) {
            for (int i = 0; i < A.length; i++) {
                stringBuilders[i].append(A[i].charAt(j));
            }
            if (!judge(stringBuilders)) {
                for (int i = 0; i < A.length; i++) {
                    stringBuilders[i].deleteCharAt(stringBuilders[i].length() - 1);
                }
                result++;
            }
        }
        return result;
    }

    private boolean judge(StringBuilder[] stringBuilders) {
        for (int i = 0; i < stringBuilders.length - 1; i++) {
            if (stringBuilders[i + 1].toString().compareTo(stringBuilders[i].toString()) < 0) {
                return false;
            }
        }
        return true;
    }
}