package question0506_relative_ranks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度是O(n * log(n))，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：13ms，击败76.74%。消耗内存：38.3MB，击败99.13%。
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[] tmpNums = new int[n];
        for (int i = 0; i < n; i++) {
            tmpNums[i] = nums[i];
        }
        Arrays.sort(tmpNums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(tmpNums[i], n - i);
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = map.get(nums[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }
}
