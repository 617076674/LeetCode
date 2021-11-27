package question2069_walking_robot_simulation_ii;

public class Robot {

  private static final String[] DIRECTIONS = {"East", "North", "West", "South"};

  private int curDirection;

  private int[] curPosition;

  private int width;

  private int height;

  public Robot(int width, int height) {
    this.width = width;
    this.height = height;
    this.curPosition = new int[] {0, 0};
  }

  public void move(int num) {
    num %= ((width + height) * 2 - 4) * 2;
    if (num == 0) {
      return;
    }
    if (curDirection == 0) {
      int max = width - curPosition[0] - 1;
      if (num <= max) {
        curPosition[0] += num;
        return;
      }
      curPosition[0] = width - 1;
      curDirection++;
      move(num - max);
    } else if (curDirection == 1) {
      int max = height - curPosition[1] - 1;
      if (num <= max) {
        curPosition[1] += num;
        return;
      }
      curPosition[1] = height - 1;
      curDirection++;
      move(num - max);
    } else if (curDirection == 2) {
      int max = curPosition[0];
      if (num <= max) {
        curPosition[0] -= num;
        return;
      }
      curPosition[0] = 0;
      curDirection++;
      move(num - max);
    } else {
      int max = curPosition[1];
      if (num <= max) {
        curPosition[1] -= num;
        return;
      }
      curPosition[1] = 0;
      curDirection = 0;
      move(num - max);
    }
  }

  public int[] getPos() {
    return curPosition;
  }

  public String getDir() {
    return DIRECTIONS[curDirection];
  }

}