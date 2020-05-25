package question0898_bitwise_ors_of_subarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 当寻找以 A[0] 结尾的按位或操作得到的结果时，直接将 A[0] 加入即可。
 *
 * 当寻找以 A[1] 结尾的按位或操作得到的结果时，首先将 A[1] 加入，然后更新 A[0] = A[1] | A[0]，再将 A[0] 加入。
 *
 * 当寻找以 A[i] 结尾的按位或操作得到的结果时，首先将 A[i] 加入，然后更新 A[j] = A[i] | A[j], j ∈ [0, i - 1]，再将 A[j] 加入。
 *
 * 令 j 从 i - 1 遍历到 0，如果 (A[j] & A[i]) == A[i]，说明 A[i] 已经无法通过按位或操作去更新 A[j]，由于是按位或操作，
 * 所以二进制表示时 A[k], k ∈ [0, j - 1] 中的 1 一定覆盖 A[j]，显然也无法去更新 A[k]。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 是数组 A 的长度。
 *
 * 执行用时：164ms，击败98.10%。消耗内存：76.3MB，击败50.00%。
 */
public class Solution2 {
    public int subarrayBitwiseORs(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            for (int j = i - 1; j >= 0; j--) {
                if((A[j] & A[i]) == A[i]) {
                    break;
                }
                A[j] |= A[i];
                set.add(A[j]);
            }
        }
        return set.size();
    }
}