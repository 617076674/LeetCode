package question1331_rank_transform_of_an_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。
 *
 * 时间复杂度是O(nlogn)，其中n为arr数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：52ms，击败54.60%。消耗内存：64.1MB，击败100.00%。
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums);
        int index = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                map.put(nums[i], index++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}