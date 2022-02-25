package question2164;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public int[] sortEvenOdd(int[] nums) {
    List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        list1.add(nums[i]);
      } else {
        list2.add(nums[i]);
      }
    }
    Collections.sort(list1);
    Collections.sort(list2, (o1, o2) -> o2 - o1);
    int[] result = new int[nums.length];
    int index1 = 0, index2 = 0;
    for (int i = 0; i < result.length; i++) {
      if (i % 2 == 0) {
        result[i] = list1.get(index1++);
      } else {
        result[i] = list2.get(index2++);
      }
    }
    return result;
  }

}