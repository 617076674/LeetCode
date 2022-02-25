package question2161;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int[] pivotArray(int[] nums, int pivot) {
    List<Integer> lessList = new ArrayList<>(), equalList = new ArrayList<>(), greaterList =
        new ArrayList<>();
    for (int num : nums) {
      if (num < pivot) {
        lessList.add(num);
      } else if (num == pivot) {
        equalList.add(num);
      } else {
        greaterList.add(num);
      }
    }
    int[] result = new int[nums.length];
    int idx = 0;
    for (int less : lessList) {
      result[idx++] = less;
    }
    for (int equal : equalList) {
      result[idx++] = equal;
    }
    for (int greater : greaterList) {
      result[idx++] = greater;
    }
    return result;
  }

}