package question0497_random_point_in_non_overlapping_rectangles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

  private int[][] rects;

  private List<Integer> psum = new ArrayList<>();

  private int total = 0;

  private Random random = new Random();

  public Solution(int[][] rects) {
    this.rects = rects;
    for (int[] rect : rects) {
      total += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
      psum.add(total);
    }
  }

  public int[] pick() {
    int randomNum = random.nextInt(total);
    int left = 0, right = rects.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (randomNum >= psum.get(mid)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    int width = rects[left][2] - rects[left][0] + 1;
    int height = rects[left][3] - rects[left][1] + 1;
    int base = psum.get(left) - width * height;
    return new int[] {rects[left][0] + (randomNum - base) % width,
        rects[left][1] + (randomNum - base) / width};
  }

}