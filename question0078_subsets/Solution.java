package question0078_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯。
 *
 * 时间复杂度是 O(2 ^ n)，其中 n 为数组 nums 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：1ms，击败99.39%。消耗内存：39MB，击败72.31%。
 */
public class Solution {

  private List<List<Integer>> listList = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    subSets(nums, new ArrayList<>(), 0);
    return listList;
  }

  private void subSets(int[] nums, List<Integer> list, int index) {
    if (index == nums.length) {
      listList.add(new ArrayList<>(list));
      return;
    }
    subSets(nums, list, index + 1);
    if (list.isEmpty() || list.get(list.size() - 1) < nums[index]) {
      list.add(nums[index]);
      subSets(nums, list, index + 1);
      list.remove(list.size() - 1);
    }
  }

}