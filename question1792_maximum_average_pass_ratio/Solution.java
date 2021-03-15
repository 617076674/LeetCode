package question1792_maximum_average_pass_ratio;

import java.util.PriorityQueue;

public class Solution {
  
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((class1, class2) -> {
      double gap1 = calculateGap(class1), gap2 = calculateGap(class2);
      return Double.compare(gap2, gap1);
    });
    for (int[] nums : classes) {
      pq.add(nums);
    }
    for (int i = 0; i < extraStudents; i++) {
      int[] nums = pq.poll();
      nums[0]++;
      nums[1]++;
      pq.add(nums);
    }
    double result = 0.0;
    while (!pq.isEmpty()) {
      int[] nums = pq.poll();
      result += nums[0] * 1.0 / nums[1];
    }
    return result / classes.length;
  }

  private static double calculateGap(int[] nums) {
    return (nums[0] + 1) * 1.0 / (nums[1] + 1) - nums[0] * 1.0 / nums[1];
  }
  
}