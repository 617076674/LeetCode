package question0090_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  private List<Integer> temp = new ArrayList<>();

  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    dfs(false, 0, nums);
    return result;
  }

  public void dfs(boolean choosePre, int cur, int[] nums) {
    if (cur == nums.length) {
      result.add(new ArrayList<>(temp));
      return;
    }
    dfs(false, cur + 1, nums);
    if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
      return;
    }
    temp.add(nums[cur]);
    dfs(true, cur + 1, nums);
    temp.remove(temp.size() - 1);
  }

}