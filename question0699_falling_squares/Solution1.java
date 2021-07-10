package question0699_falling_squares;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

  public List<Integer> fallingSquares(int[][] positions) {
    int[] maxHeights = new int[positions.length]; // maxHeights 表示方块 i 的最大高度
    for (int i = 0; i < positions.length; i++) {
      int left = positions[i][0];
      int size = positions[i][1];
      int right = left + size;
      maxHeights[i] += size;
      for (int j = i + 1; j < positions.length; j++) {
        int left2 = positions[j][0];
        int size2 = positions[j][1];
        int right2 = left2 + size2;
        if (left2 < right && left < right2) {
          maxHeights[j] = Math.max(maxHeights[j], maxHeights[i]);
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    int cur = -1;
    for (int maxHeight : maxHeights) {
      cur = Math.max(cur, maxHeight);
      result.add(cur);
    }
    return result;
  }

}
