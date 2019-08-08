package question0370;

/**
 * @author qianyihui
 * @date 2019-08-08
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(length * n)，其中n为updates的行数。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            for (int j = updates[i][0]; j <= updates[i][1]; j++) {
                result[j] += updates[i][2];
            }
        }
        return result;
    }
}
