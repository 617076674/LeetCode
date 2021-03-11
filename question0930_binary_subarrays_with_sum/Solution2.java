package question0930_binary_subarrays_with_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和。sum[i] = A[0] + A[1] + ... + A[i - 1]
 *
 * 以题给示例做说明，A = [1, 0, 1, 0, 1], S = 2
 *
 * 数组A的前缀和为sum = [0, 1, 1, 2, 2, 3]。我们可以对数组sum进行一次线性扫描，当扫描到sum[j]时，
 * 我们需要得到的是满足sum[j] = sum[i] + S且i < j的sum[j]的数目，使用map可以满足要求。
 *
 * 时间复杂度和空间复杂度均为O(n)。
 *
 * 执行用时：15ms，击败64.10%。消耗内存：50MB，击败38.64%。
 */
public class Solution2 {

    public int numSubarraysWithSum(int[] A, int S) {
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int tmp : sum) {
            //如果说map包含tmp，显然其左边界也是有的，因为tmp是其右边界
            //而且，由于我们先判断map中是否包含tmp，因此此时的左边界一定是小于等于右边界的，不会出现左边界大于右边界的情况
            if (map.containsKey(tmp)) {
                result += map.get(tmp);
            }
            //我们加入map的是tmp + S，即右边界
            map.put(tmp + S, map.getOrDefault(tmp + S, 0) + 1);
        }
        return result;
    }

}