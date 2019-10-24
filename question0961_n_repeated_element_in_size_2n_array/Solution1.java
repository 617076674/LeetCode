package question0961_n_repeated_element_in_size_2n_array;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为数组A的长度。
 *
 * 执行用时：1ms，击败96.66%。消耗内存：37.6MB，击败97.18%。
 */
public class Solution1 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
