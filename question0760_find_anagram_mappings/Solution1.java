package question0760_find_anagram_mappings;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为数组A的长度。空间复杂度是O(n)。
 *
 * 执行用时：1ms，击败96.30%。消耗内存：38.2MB，击败8.57%。
 */
public class Solution1 {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        boolean[] visited = new boolean[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[j] && B[j] == A[i]) {
                    result[i] = j;
                    visited[j] = true;
                    break;
                }
            }
        }
        return result;
    }
}