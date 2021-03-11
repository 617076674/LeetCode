package question1630_arithmetic_subarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < l.length; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = l[i]; j <= r[i]; j++) {
        list.add(nums[j]);
      }
      Collections.sort(list);
      if (list.size() < 2) {
        result.add(false);
      } else {
        int diff = list.get(1) - list.get(0);
        int j = 2;
        for (; j < list.size(); j++) {
          if (diff != list.get(j) - list.get(j - 1)) {
            result.add(false);
            break;
          }
        }
        if (j >= list.size()) {
          result.add(true);
        }
      }
    }
    return result;
  }

}