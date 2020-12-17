package question0973_k_closest_points_to_origin;

/**
 * 快排。
 *
 * 时间复杂度是 O(n)，其中 n 为 points 数组的长度。空间复杂度是 O(logn)。
 *
 * 执行用时：36ms，击败41.13%。消耗内存：46.7MB，击败91.09%。
 */
public class Solution2 {

  public int[][] kClosest(int[][] points, int K) {
    sort(points, 0, points.length - 1, K);
    int[][] result = new int[K][2];
    for (int i = 0; i < K; i++) {
      result[i] = points[i];
    }
    return result;
  }

  private void sort(int[][] points, int left, int right, int k) {
    if (left >= right) {
      return;
    }
    swap(points, left, (int) (left + Math.random() * (right - left) + 1));
    //[left + 1, lessThan], [lessThan + 1, i), [greaterThan, right]
    int lessThan = left, i = left + 1, greaterThan = right + 1;
    while (i < greaterThan) {
      if (calculateDistance(points[i]) == calculateDistance(points[left])) {
        i++;
      } else if (calculateDistance(points[i]) > calculateDistance(points[left])) {
        greaterThan--;
        swap(points, i, greaterThan);
      } else {
        lessThan++;
        swap(points, i, lessThan);
        i++;
      }
    }
    //[left + 1, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    swap(points, left, lessThan);
    lessThan--;
    //[left, lessThan], [lessThan + 1, greaterThan - 1], [greaterThan, right]
    //[0, lessThan - left], [lessThan + 1 - left, greaterThan - 1 - left], [greaterThan - left, right - left]
    if (k - 1 <= lessThan - left) {
      sort(points, left, lessThan, k);
    } else if (k - 1 > greaterThan - 1 - left) {
      sort(points, greaterThan, right, k - greaterThan + left);
    }
  }

  private int calculateDistance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }

  private void swap(int[][] points, int i, int j) {
    int[] tmp = new int[2];
    tmp[0] = points[i][0];
    tmp[1] = points[i][1];
    points[i] = points[j];
    points[j] = tmp;
  }

}