package question0795;

/**
 * @author qianyihui
 * @date 2019-08-18
 *
 * 最大元素大于等于L且小于等于R的区间个数 = 最大元素小于等于R的区间个数 - 最大元素小于等于(L - 1)的区间个数。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败95.35%。消耗内存：51.5MB，击败74.36%。
 */
public class Solution2 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    private int numSubarrayBoundedMax(int[] A, int R) {
        int result = 0, pre = -1, n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] > R) {
                result += (((i - pre - 1) * (i - pre)) >> 1);
                pre = i;
            }
        }
        result += ((n - pre - 1) * (n - pre) >> 1);
        return result;
    }
}
