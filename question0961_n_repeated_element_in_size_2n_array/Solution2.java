package question0961_n_repeated_element_in_size_2n_array;

/**
 * 对数组A来说，出现N次的那个数，一定存在某个位置i，使得A[i]会与A[i + 1]、A[i + 2]或A[i + 3]相等。
 *
 * 反证法，如果不存在满足上述条件的i，即对于数组A中的任何位置i，A[i]与A[i + 1]、A[i + 2]和A[i + 3]均不相等。
 *
 * 那么出现次数最多的数字只可能是N/2，而不可能是N。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：38.3MB，击败95.39%。
 */
public class Solution2 {
    public int repeatedNTimes(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i + j < n && A[i + j] == A[i]) {
                    return A[i];
                }
            }
        }
        return -1;
    }
}
