package question0885_spiral_matrix_iii;

public class Solution {

  public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    int[][] result = new int[R * C][2];
    int[][] around = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int curR = r0, curC = c0, num = 0, dir = 0;  //{curR, curC}为当前位置，num为当前查找的数字，dir为当前的方向
    int left = c0 - 1, right = c0 + 1, top = r0 - 1, bottom = r0 + 1;  //四个方向的边界
    while (num < R * C) {
      if (curR >= 0 && curR < R && curC >= 0 && curC < C) {  //{curR， curC}位置在矩阵中
        result[num++] = new int[] {curR, curC};
      }
      if (dir == 0 && curC == right) {  //向右到右边界
        dir++;  //调转方向向下
        right++;  //右边界右移
      } else if (dir == 1 && curR == bottom) {  //向下到底边界
        dir++;
        bottom++;  //底边界下移
      } else if (dir == 2 && curC == left) {  //向左到左边界
        dir++;
        left--;  //左边界左移
      } else if (dir == 3 && curR == top) {  //向上到上边界
        dir = 0;
        top--;  //上边界上移
      }
      curR += around[dir][0];   //下一个节点
      curC += around[dir][1];
    }
    return result;
  }

}