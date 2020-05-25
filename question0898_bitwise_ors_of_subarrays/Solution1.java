package question0898_bitwise_ors_of_subarrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 状态定义：
 * dp[i] 表示数组 A 中以 A[i] 结尾的子数组按位或操作所得的结果集合。
 *
 * 初始化条件：
 * dp[0] 中仅有一个元素，就是 A[0]。
 *
 * 状态转移方程：
 * dp[i] = A[i] | (dp[i - 1] 中的所有元素) , dp[i] 还包括 A[i]。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 是数组 A 的长度。
 *
 * 执行用时：520ms，击败29.05%。消耗内存：69.9MB，击败100.00%。
 */
public class Solution1 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> pre = new HashSet<>(), set = new HashSet<>();
        pre.add(A[0]);
        set.addAll(pre);
        for (int i = 1; i < A.length; i++) {
            Set<Integer> cur = new HashSet<>();
            for (int num : pre) {
                cur.add(num | A[i]);
            }
            cur.add(A[i]);
            set.addAll(cur);
            pre = cur;
        }
        return set.size();
    }
}