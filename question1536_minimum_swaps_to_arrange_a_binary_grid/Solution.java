package question1536_minimum_swaps_to_arrange_a_binary_grid;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int minSwaps(int[][] grid) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      int count0 = 0;
      for (int j = grid[i].length - 1; j >= 0; j--) {
        if (grid[i][j] == 0) {
          count0++;
        } else {
          break;
        }
      }
      list.add(count0);
    }
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      int target = grid.length - i - 1;
      boolean removed = false;
      for (int j = 0; j < list.size(); j++) {
        if (target <= list.get(j)) {
          result += j;
          list.remove(j);
          removed = true;
          break;
        }
      }
      if (!removed) {
        return -1;
      }
    }
    return result;
  }

}