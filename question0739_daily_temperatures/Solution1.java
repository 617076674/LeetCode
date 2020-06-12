package question0739_daily_temperatures;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为数组 T 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：936ms，击败17.18%。消耗内存：48.2MB，击败6.45%。
 */
public class Solution1 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}