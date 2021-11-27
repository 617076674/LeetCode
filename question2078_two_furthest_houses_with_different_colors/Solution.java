package question2078_two_furthest_houses_with_different_colors;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int maxDistance(int[] colors) {
    List<Integer>[] sameColorLists = new ArrayList[101];
    for (int i = 0; i < colors.length; i++) {
      if (null == sameColorLists[colors[i]]) {
        sameColorLists[colors[i]] = new ArrayList<>();
      }
      sameColorLists[colors[i]].add(i);
    }
    int result = 0;
    for (int i = 0; i < sameColorLists.length; i++) {
      for (int j = 0; j < sameColorLists.length; j++) {
        if (null != sameColorLists[i] && null != sameColorLists[j] && i != j) {
          result = Math.max(result, Math.max(Math.abs(sameColorLists[i].get(0) - sameColorLists[j].get(sameColorLists[j].size() - 1)), Math.abs(sameColorLists[j].get(0) - sameColorLists[i].get(sameColorLists[i].size() - 1))));
        }
      }
    }
    return result;
  }

}