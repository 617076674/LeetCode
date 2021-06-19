package question1755_closest_subsequence_sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    int[] nums = {5, -7, 3, 5};
    int goal = 6;
    System.out.println(new Solution().minAbsDifference(nums, goal));
  }

  public int minAbsDifference(int[] nums, int goal) {
    List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
    int mid = nums.length / 2;
    dfs(nums, 0, mid - 1, 0, 0, list1);
    dfs(nums, mid, nums.length - 1, mid, 0, list2);
    Collections.sort(list1);
    Collections.sort(list2, (num1, num2) -> num2 - num1);
    int index1 = 0, index2 = 0, result = Integer.MAX_VALUE;
    while (index1 < list1.size() && index2 < list2.size()) {
      int sum = list1.get(index1) + list2.get(index2);
      result = Math.min(result, Math.abs(sum - goal));
      if (goal == sum) {
        return 0;
      } else if (goal > sum) {
        index1++;
      } else {
        index2++;
      }
    }
    return result;
  }

  private void dfs(int[] nums, int left, int right, int index, int sum, List<Integer> list) {
    if (index == right + 1) {
      list.add(sum);
      return;
    }
    dfs(nums, left, right, index + 1, sum + nums[index], list);
    dfs(nums, left, right, index + 1, sum, list);
  }

}