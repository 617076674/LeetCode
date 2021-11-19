package question2044_count_number_of_maximum_bitwise_or_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int countMaxOrSubsets(int[] nums) {
    dfs(nums, 0, new ArrayList<>());
    int count = 0, max = -1;
    for (List<Integer> list : listList) {
      int temp = 0;
      for (int num : list) {
        temp |= num;
      }
      if (temp > max) {
        max = temp;
        count = 1;
      } else if (temp == max) {
        count++;
      }
    }
    return count;
  }

  private List<List<Integer>> listList = new ArrayList<>();

  private void dfs(int[] nums, int index, List<Integer> list) {
    if (index == nums.length) {
      listList.add(new ArrayList<>(list));
      return;
    }
    dfs(nums, index + 1, list);
    list.add(nums[index]);
    dfs(nums, index + 1, list);
    list.remove(list.size() - 1);
  }

}