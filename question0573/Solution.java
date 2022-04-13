package question0573;

public class Solution {

  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    // 求出树到所有坚果的距离
    int[] distances = new int[nuts.length];
    int sum = 0;
    for (int i = 0; i < nuts.length; i++) {
      distances[i] = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
      sum += distances[i] * 2;
    }
    int result = Integer.MAX_VALUE;
    // 枚举第一颗坚果
    for (int i = 0; i < nuts.length; i++) {
      result = Math.min(result,
          Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]) + sum - distances[i]);
    }
    return result;
  }

}