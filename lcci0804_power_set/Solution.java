package lcci0804_power_set;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：1ms，击败99.26%。消耗内存：39.9MB，击败100.00%。
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.remove(list.size() - 1);
        dfs(nums, index + 1, list);
    }
}