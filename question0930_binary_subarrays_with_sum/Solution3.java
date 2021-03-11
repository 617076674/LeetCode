package question0930_binary_subarrays_with_sum;

/**
 * 滑动窗口法，双指针。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败83.33%。消耗内存：49.8MB，击败40.91%。
 */
public class Solution3 {

    public int numSubarraysWithSum(int[] A, int S) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int left = 0, right = -1, sum = 0, result = 0;
        while (right + 1 < n) {
            right++;
            sum += A[right];
            while (sum > S) {   //经过这个while循环后，left很可能大于right，比如当A = [0, 0, 0, 1]， S = 0，right = 3的情况
                sum -= A[left];
                left++;
            }
            if (sum == S && left <= right) {    //因为我们定义的滑动窗口是[left, right]，故这里需要确保left <= right
                int tmp = left;
                while (tmp < right && A[tmp] == 0) {
                    result++;
                    tmp++;
                }
                result++;
            }
        }
        return result;
    }

}
