package question0967;

import java.util.HashSet;
import java.util.Set;

/**
 * 递归。
 *
 * 时间复杂度是O(2 ^ N)。空间复杂度是O(N)。
 *
 * 执行用时：15ms，击败51.04%。消耗内存：39.3MB，击败42.86%。
 */
public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        Set<Integer> set = numsSameConsecDiff(N, K, 0, new HashSet<>());
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer tmp : set) {
            result[index++] = tmp;
        }
        return result;
    }

    /**
     * 寻找长度为N（n > 1）且满足其每两个连续位上的数字之差的绝对值为K的非负整数，
     * 目前在list中已经存储了长度为count的且满足其两个连续位上的数字之差的绝对值为K的非负整数
     */
    private Set<Integer> numsSameConsecDiff(int N, int K, int count, Set<Integer> set) {
        if (count == N) {
            return set;
        }
        Set<Integer> nextSet = new HashSet<>();
        if (set.size() > 0) {
            for (Integer tmp : set) {
                int last = tmp % 10;
                if (last - K >= 0) {
                    nextSet.add(tmp * 10 + last - K);
                }
                if (last + K <= 9) {
                    nextSet.add(tmp * 10 + last + K);
                }
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                nextSet.add(i);
            }
        }
        return numsSameConsecDiff(N, K, count + 1, nextSet);
    }
}
