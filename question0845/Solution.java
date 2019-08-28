package question0845;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度，空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败46.80%。消耗内存：49.3MB，击败38.98%。
 */
public class Solution {
    public int longestMountain(int[] A) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < n - 2; ) {
            int j = i + 1;
            boolean up = false, down = false;
            while (j < n && A[j] > A[j - 1]) {
                j++;
                up = true;  //出现上升沿
            }
            if (up) {
                while (j < n && A[j] < A[j - 1]) {
                    j++;
                    down = true;    //出现下降沿
                }
                if (down) { //如果既有上升沿又有下降沿，本身就已经保证了子数组的长度大于等于3
                    result = Math.max(result, j - i);
                }
            }
            i = j;
            if (down) {
                i--;    //如果出现过下降沿，需要从下降沿末开始寻找
            }
        }
        return result;
    }
}
