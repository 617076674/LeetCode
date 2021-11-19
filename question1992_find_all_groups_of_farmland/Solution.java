package question1992_find_all_groups_of_farmland;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int m, n;

  public int[][] findFarmland(int[][] land) {
    List<int[]> list = new ArrayList<>();
    m = land.length;
    n = land[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (land[i][j] == 1) {
          int[] nums = new int[4];
          nums[0] = nums[2] = i;
          nums[1] = nums[3] = j;
          dfs(land, i, j, nums);
          list.add(nums);
        }
      }
    }
    int[][] result = new int[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  private void dfs(int[][] land, int curX, int curY, int[] nums) {
    land[curX][curY] = 2;
    nums[0] = Math.min(curX, nums[0]);
    nums[1] = Math.min(curY, nums[1]);
    nums[2] = Math.max(curX, nums[2]);
    nums[3] = Math.max(curY, nums[3]);
    for (int[] direction : directions) {
      int nextX = curX + direction[0], nextY = curY + direction[1];
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && land[nextX][nextY] == 1) {
        dfs(land, nextX, nextY, nums);
      }
    }
  }

}