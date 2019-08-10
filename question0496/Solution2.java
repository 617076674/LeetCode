package question0496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-10
 *
 * 哈希表。
 *
 * 时间复杂度是O(n1 + n2)，其中n1是nums1数组的长度，n2是nums2数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：7ms，击败83.46%。消耗内存：37.9MB，击败52.34%。
 */
public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[n1];
        Arrays.fill(result, -1);
        for (int i = 0; i < n1; i++) {
            int j = map.get(nums1[i]);
            while (j + 1 < n2) {
                j++;
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
