package question1313_decompress_run_length_encoded_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：5ms，击败58.33%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}