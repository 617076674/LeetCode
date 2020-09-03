package question0491_increasing_subsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是 O(2 ^ n)，其中 n 为 nums 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：5ms，击败98.29%。消耗内存：47.4MB，击败100.00%。
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, int index) {
        if (index >= nums.length) {
            if (list.size() >= 2) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // 把第 index 个元素加进 list 中
        if (list.isEmpty() || nums[index] >= list.get(list.size() - 1)) {
            list.add(nums[index]);
            dfs(nums, list, index + 1);
            list.remove(list.size() - 1);
        }
        if (index > 0 && !list.isEmpty() && nums[index] == list.get(list.size() - 1)) {
            return;
        }
        // 不把第 index 个元素加进 list 中
        dfs(nums, list, index + 1);
    }
}