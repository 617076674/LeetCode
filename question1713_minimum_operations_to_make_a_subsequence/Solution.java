package question1713_minimum_operations_to_make_a_subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int minOperations(int[] target, int[] arr) {
    Map<Integer, Integer> targetMap = new HashMap<>();
    for (int i = 0; i < target.length; i++) {
      targetMap.put(target[i], i);
    }
    List<Integer> list = new ArrayList<>();
    for (int num : arr) {
      Integer index = targetMap.get(num);
      if (null != index) {
        list.add(index);
      }
    }
    return target.length - lengthOfLIS(list);
  }

  private int lengthOfLIS(List<Integer> nums) {
    int n;
    if (nums == null || (n = nums.size()) == 0) {
      return 0;
    }
    int[] tops = new int[n];    // 每堆扑克牌堆顶的牌
    tops[0] = nums.get(0);  // 第一张牌显然只能新建一堆
    int piles = 1;  // 现在一共有piles堆扑克牌
    for (int i = 1; i < n; i++) {
      // 在[0, piles - 1]范围内寻找第一处比nums[i]大的位置，即ceil函数
      int left = 0, right = piles - 1;
      while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (tops[mid] == nums.get(i)) {
          left = mid + 1;
        } else if (tops[mid] < nums.get(i)) {
          left = mid + 1;
        } else if (tops[mid] > nums.get(i)) {
          right = mid - 1;
        }
      }
      if (left - 1 >= 0 && tops[left - 1] == nums.get(i)) {
        continue;
      }
      if (left == piles) {
        piles++;
      }
      tops[left] = nums.get(i);
    }
    return piles;
  }

}