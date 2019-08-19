package question0795;

/**
 * @author qianyihui
 * @date 2019-08-18
 *
 * 滑动窗口法。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败53.49%。消耗内存：51.8MB，击败74.36%。
 */
public class Solution1 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int result = 0, left = 0, right = 0;    //滑动窗口范围是[left, right]
        while (right < n) {
            if (A[right] >= L && A[right] <= R) {   //如果A[right]是满足条件的
                result += right - left + 1; //那么，滑动窗口中，以A[right]结尾的子数组都是满足条件的
            } else if (A[right] < L) {  //如果A[right]是比L还要小的，那么显然以A[right]结尾的子数组是不满足条件的
                int tmp = right - 1;    //但是，在[left, right - 1]范围内可能存在tmp，使得A[tmp]<L
                while (tmp >= left && A[tmp] < L) {
                    tmp--;
                }
                result += tmp - left + 1;   //以A[right]结尾的子数组，其左边界的值小于等于tmp，这些子数组都是满足条件的
            } else {
                left = right + 1;   //如果出现了A[right] > R的情况，此时滑动窗口的左边界需要右移
            }
            right++;    //每一轮都向右移动right指针
        }
        return result;
    }
}
