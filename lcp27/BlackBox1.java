package lcp27;

public class BlackBox1 {

  private int n, m;

  private int[] data;

  public BlackBox1(int n, int m) {
    this.n = n;
    this.m = m;
    this.data = new int[2 * (n + m)];
  }

  public int open(int index, int direction) {
    data[index] = 1;
    int target = reflectTo(index, direction);
    return target == -1 ? index : target;
  }

  public void close(int index) {
    this.data[index] = 0;
  }

  private int reflectTo(int index, int direction) {
    while (true) {
      int nextIndex;
      if (direction > 0) {
        //方向为1时带入公式 2m+2n-index
        nextIndex = 2 * (m + n) - index;
      } else {
        //方向为-1时带入公式 2m-index
        nextIndex = 2 * m - index;
      }
      //纠正方向为-1时结果为负数的情况，实际公式为 4m+2n-index
      if (nextIndex < 0) {
        nextIndex += 2 * (m + n);
      }
      //检查该点位是否打开，打开则直接返回
      if (data[nextIndex] == 1) {
        return nextIndex;
      }
      //未打开，但该点位为角，返回-1表示将沿原路返回初始点位
      if (nextIndex == 0 || nextIndex == m || nextIndex == m + n || nextIndex == m + n + m) {
        return -1;
      }
      //否则将继续遍历
      index = nextIndex;
      direction = -direction;
    }

  }

}