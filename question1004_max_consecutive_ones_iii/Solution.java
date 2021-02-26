package question1004_max_consecutive_ones_iii;

/**
 * 和question0487相同，滑动窗口法解决。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：11ms，击败54.27%。消耗内存：52.3MB，击败44.08%。
 */
public class Solution {

    public int longestOnes(int[] A, int K) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int left = 0, right = -1, result = 0, countZero = 0;
        while (right + 1 < n) {
            right++;
            if (A[right] == 0) {    //如果right位置处的值是0
                countZero++;
                if (countZero > K) {
                    while (A[left] != 0) {
                        left++;
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}