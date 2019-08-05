package question0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 4)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    for (int m = k + 1; m < n; m++) {
                        if (m > k + 1 && nums[m] == nums[m - 1]) {
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            listList.add(list);
                        }
                    }
                }
            }
        }
        return listList;
    }
}
