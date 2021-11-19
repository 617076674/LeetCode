package question2033_minimum_operations_to_make_a_uni_value_grid;

public class Solution {

  public int minOperations(int[][] grid, int x) {
    int m = grid.length, n = grid[0].length;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        min = Math.min(min, grid[i][j]);
        max = Math.max(max, grid[i][j]);
      }
    }
    if ((max - min) % x != 0) {
      return -1;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((grid[i][j] - min) % x != 0) {
          return -1;
        }
      }
    }
    int[] array = new int[(max - min) / x + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        array[(grid[i][j] - min) / x]++;
      }
    }
    int[] sums = new int[array.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + array[i - 1];
    }
    int temp = 0;
    for (int i = 1; i < array.length; i++) {
      temp += array[i] * i;
    }
    int result = temp;
    for (int i = 1; i < array.length; i++) {
      temp += sums[i] - (sums[sums.length - 1] - sums[i]);
      result = Math.min(result, temp);
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,2},{3,4}};
    int x = 2;
    System.out.println(new Solution().minOperations(grid, x));
  }

}