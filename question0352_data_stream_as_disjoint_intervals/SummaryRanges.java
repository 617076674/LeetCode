package question0352_data_stream_as_disjoint_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

  /**
   * Initialize your data structure here.
   */
  private List<Integer> edges = new ArrayList<>();

  public SummaryRanges() {

  }

  public static void main(String[] args) {
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(6);
    summaryRanges.addNum(0);
    summaryRanges.addNum(4);
    System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
  }

  public void addNum(int val) {
    int ceilIndex = ceil(edges, val);
    if (ceilIndex == edges.size()) {
      if (edges.isEmpty() || edges.get(edges.size() - 1) + 1 != val) {
        edges.add(val);
        edges.add(val);
      } else {
        edges.set(edges.size() - 1, val);
      }
      return;
    }
    if (edges.get(ceilIndex) == val) {
      return;
    }
    int floorIndex = floor(edges, val);
    if (floorIndex == -1) {
      if (edges.isEmpty() || edges.get(0) - 1 != val) {
        edges.add(0, val);
        edges.add(0, val);
      } else {
        edges.set(0, val);
      }
      return;
    }
    if ((floorIndex & 1) == 0) {
      return;
    }
    if (edges.get(floorIndex) + 1 == val) {
      if (edges.get(ceilIndex) - 1 == val) {
        edges.remove(floorIndex);
        edges.remove(ceilIndex - 1);
      } else {
        edges.set(floorIndex, val);
      }
      return;
    }
    if (edges.get(ceilIndex) - 1 == val) {
      edges.set(ceilIndex, val);
    } else {
      edges.add(floorIndex + 1, val);
      edges.add(floorIndex + 2, val);
    }
  }

  private static int ceil(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) == target) {
        left = mid + 1;
      } else if (nums.get(mid) < target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (right >= 0 && nums.get(right) == target) {
      return right;
    }
    return left;
  }

  private static int floor(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) == target) {
        right = mid - 1;
      } else if (nums.get(mid) > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < nums.size() && nums.get(left) == target) {
      return left;
    }
    return right;
  }

  public int[][] getIntervals() {
    int[][] result = new int[edges.size() / 2][2];
    int index = 0;
    for (int i = 0; i < result.length; i++) {
      result[i][0] = edges.get(index++);
      result[i][1] = edges.get(index++);
    }
    return result;
  }

}