package question0454_4sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 2)，其中 n 为数组 A 的长度。
 *
 * 执行用时：81ms，击败77.26%。消耗内存：58.9MB，击败12.50%。
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                mapAB.put(numA + numB, mapAB.getOrDefault(numA + numB, 0) + 1);
            }
        }
        int result = 0;
        for (int numC : C) {
            for (int numD : D) {
                result += mapAB.getOrDefault(-numC - numD, 0);
            }
        }
        return result;
    }
}