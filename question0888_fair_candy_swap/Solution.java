package question0888_fair_candy_swap;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n2)，其中n1为数组A的长度，n2为数组B的长度。空间复杂度是O(n2)。
 *
 * 执行用时：15ms，击败97.07%。消耗内存：40.7MB，击败94.35%。
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        for (int num : A) {
            sum1 += num;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : B) {
            sum2 += num;
            set.add(num);
        }
        int half = (sum1 + sum2) >> 1;
        int[] result = new int[2];
        for (int num : A) {
            if (set.contains(half - sum1 + num)) {
                result[0] = num;
                result[1] = half - sum1 + num;
                return result;
            }
        }
        return null;
    }
}
