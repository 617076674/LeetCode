package question0873;

import java.util.HashSet;
import java.util.Set;

/**
 * 利用set保存A中所有的元素。
 *
 * 时间复杂度是O(n ^ 2)，其中n为数组A的长度。空间复杂度是O(n)。
 *
 * 执行用时：168ms，击败45.95%。消耗内存：66.8MB，击败40.47%。
 */
public class Solution1 {
    public int lenLongestFibSubseq(int[] A) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int first = A[i], second = A[j];
                int len = 2;
                while (true) {
                    int tmp = first + second;
                    if (!set.contains(tmp)) {
                        break;
                    }
                    first = second;
                    second = tmp;
                    len++;
                }
                result = Math.max(result, len);
            }
        }
        return result >= 3 ? result : 0;
    }
}
