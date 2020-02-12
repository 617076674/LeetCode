package question0396_rotate_function;

/**
 * 找规律。
 *
 * F(0) = 0 * A[0] + 1 * A[1] + 2 * A[2] + ... + (n - 1) * A[n - 1]
 * F(1) = 0 * A[n - 1] + 1 * A[0] + 2 * A[1] + ... + (n - 1) * A[n - 2]
 * F(2) = 0 * A[n - 2] + 1 * A[n - 1] + 2 * A[0] + ... + (n - 1) * A[n - 3]
 * F(3) = 0 * A[n - 3] + 1 * A[n - 2] + 2 * A[n - 1] + ... + (n - 1) * A[n - 4]
 * ...
 *
 * F(1) - F(0) = A[0] + A[1] + A[2] + ... + A[n - 2] - (n - 1) * A[n - 1]
 * = A[0] + A[1] + A[2] + ... + A[n - 1] - n * A[n - 1] = sum - n * A[n - 1]
 * F(2) - F(1) = A[0] + A[1] + A[2] + ... + A[n - 3] + A[n - 1] - (n - 1) * A[n - 2]
 * = A[0] + A[1] + A[2] + ... + A[n - 1] - n * A[n - 2] = sum - n * A[n - 2]
 * F(3) - F(2) = A[0] + A[1] + A[2] + ... + A[n - 4] + A[n - 2] + A[n - 1] - (n - 1) * A[n - 3]
 * = A[0] + A[1] + A[2] + ... + A[n - 1] - n * A[n - 3] = sum - n * A[n - 3]
 * ...
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败90.00%。消耗内存：47.2MB，击败5.44%。
 */
public class Solution {
    public int maxRotateFunction(int[] A) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        int tmp = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            tmp += i * A[i];
        }
        int result = tmp;
        for (int i = 1; i < n; i++) {
            tmp += sum - n * A[n - i];
            result = Math.max(tmp, result);
        }
        return result;
    }
}