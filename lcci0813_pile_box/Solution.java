package lcci0813_pile_box;

import java.util.Arrays;

/**
 * 记忆化搜索。
 *
 * 执行用时：83ms，击败10.12%。消耗内存：38.3MB，击败77.46%。
 */
public class Solution {

  private int[] memo;

  public int pileBox(int[][] box) {
    Arrays.sort(box, (box1, box2) -> {
      if (box1[2] == box2[2]) {
        if (box1[1] == box2[1]) {
          return box2[0] - box1[0];
        }
        return box2[1] - box1[1];
      }
      return box2[2] - box1[2];
    });
    memo = new int[box.length];
    int result = 0;
    for (int i = 0; i < box.length; i++) {
      result = Math.max(result, dfs(box, i, -1));
    }
    return result;
  }

  // 前一个箱子是 pre，考虑 [i, box.length - 1] 范围内的箱子所能堆积的最大高度
  private int dfs(int[][] box, int i, int pre) {
    if ((i == box.length) || (pre != -1 && !(box[i][0] < box[pre][0] && box[i][1] < box[pre][1]
        && box[i][2] < box[pre][2]))) {
      return 0;
    }
    if (memo[i] != 0) {
      return memo[i];
    }
    for (int j = i; j < box.length; j++) {
      memo[i] = Math.max(memo[i], box[i][2] + dfs(box, j + 1, i));
    }
    return memo[i];
  }

}