package question1248_count_number_of_nice_subarrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 记录奇数值的索引。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为nums数组的长度。
 *
 * 执行用时：12ms，击败55.81%。消耗内存：48.2MB，击败100.00%。
 */
public class Solution2 {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddIndexList = new ArrayList<>();
        oddIndexList.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                oddIndexList.add(i);
            }
        }
        oddIndexList.add(nums.length);
        int result = 0;
        for (int i = 1; i + k < oddIndexList.size(); i++) {
            result += (oddIndexList.get(i) - oddIndexList.get(i - 1)) * (oddIndexList.get(i + k) - oddIndexList.get(i + k - 1));
        }
        return result;
    }
}
