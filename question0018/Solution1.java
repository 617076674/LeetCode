package question0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 4)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：414ms，击败5.06%。消耗内存：48.5MB，击败27.31%。
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return listList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {   //这个判断很重要，不然会超时
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 1] > target) {   //这个判断很重要，不然会超时
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < n - 1; k++) {
                    if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {   //这个判断很重要，不然会超时
                        break;
                    }
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    for (int m = k + 1; m < n; m++) {
                        if (m > k + 1 && nums[m] == nums[m - 1]) {
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            addToListList(nums[i], nums[j], nums[k], nums[m], listList);
                        }
                    }
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, int num4, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        listList.add(list);
    }
}
