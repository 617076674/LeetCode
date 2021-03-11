package question0930_binary_subarrays_with_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设数组A的长度为n，先统计出所有1的索引值，假设总共有k个1，其索引值分别为x1, x2, x3, ... , xk
 *
 * （1）若S为0，
 * 在[0, x1)间0的个数为x1个，记tmp = x1，其可能的子数组个数是tmp * (tmp + 1) / 2个
 * 在(x1, x2)间0的个数为(x2 - x1 - 1)个，记tmp = (x2 - x1 - 1)，其可能的子数组个数是tmp * (tmp + 1) / 2个
 * 在(xk, n - 1]间0的个数为(n - xk - 1)个，记tmp = (n - xk - 1)，其可能的子数组个数是tmp * (tmp + 1) / 2个
 *
 * 为避免对上述三种情况做特殊处理，在x1, x2, x3, ... , xk的前后各加上一个数变为-1, x1, x2, x3, ... , xk, n
 * （2）若S不为0
 * 对于每一个左边界left，寻找right = left + S - 1处的值。left左边的0的个数乘以right右边0的个数，就是这个
 * [left, right]区间对应的子数组个数。
 *
 * 时间复杂度和空间复杂度均为O(n)。
 *
 * 执行用时：15ms，击败64.10%。消耗内存：50MB，击败38.64%。
 */
public class Solution1 {
    public int numSubarraysWithSum(int[] A, int S) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < n; i++) {
            if (A[i] == 1) {
                list.add(i);
            }
        }
        list.add(n);
        int result = 0;
        if (S == 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                int tmp = list.get(i + 1) - list.get(i) - 1;
                result += tmp * (tmp + 1) / 2;
            }
            return result;
        }
        for (int left = 1; left < list.size() - S; left++) {
            int right = left + S - 1;
            int leftZero = list.get(left) - list.get(left - 1);
            int rightZero = list.get(right + 1) - list.get(right);
            result += leftZero * rightZero;
        }
        return result;
    }
}
