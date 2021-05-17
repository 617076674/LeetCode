package question1620_coordinate_with_maximum_network_quality;

public class Solution {

  public int[] bestCoordinate(int[][] towers, int radius) {
    int[] result = new int[2];
    int maxSignal = 0;
    for (int i = 0; i <= 50; i++) {
      for (int j = 0; j <= 50; j++) {
        int tempSignal = getSignal(towers, radius, i, j);
        if (tempSignal > maxSignal) {
          maxSignal = tempSignal;
          result[0] = i;
          result[1] = j;
        }
      }
    }
    return result;
  }

  private int getSignal(int[][] towers, int radius, int x, int y) {
    int maxDistance2 = radius * radius;
    int result = 0;
    for (int[] tower : towers) {
      int tempDistance2 = getDistance2(tower[0], tower[1], x, y);
      if (tempDistance2 <= maxDistance2) {
        result += tower[2] / (1 + Math.sqrt(tempDistance2));
      }
    }
    return result;
  }

  private int getDistance2(int x1, int y1, int x2, int y2) {
    return (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
  }

}