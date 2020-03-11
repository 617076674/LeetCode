package question0760_find_anagram_mappings;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为数组A的长度。
 *
 * 执行用时：1ms，击败96.30%。消耗内存：38.2MB，击败8.57%。
 */
public class Solution2 {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(B[i], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(A[i]);
        }
        return result;
    }
}