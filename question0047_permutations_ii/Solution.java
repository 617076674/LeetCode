package question0047_permutations_ii;

import java.util.*;

/**
 * 回溯。
 *
 * 时间复杂度是O(n!)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：2ms，击败96.41%。消耗内存：39.7MB，击败91.28%。
 */
public class Solution {
    private List<List<Integer>> listList = new ArrayList<>();

    private boolean[] used;

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return listList;
    }

    private void dfs(int[] nums) {
        if (list.size() == nums.length) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                list.add(nums[i]);
                dfs(nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}