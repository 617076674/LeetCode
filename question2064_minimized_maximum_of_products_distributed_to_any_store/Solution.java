package question2064_minimized_maximum_of_products_distributed_to_any_store;

public class Solution {

  public int minimizedMaximum(int n, int[] quantities) {
    int right = -1;
    for (int quantity : quantities) {
      right = Math.max(right, quantity);
    }
    int left = 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (check(quantities, n, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static boolean check(int[] quantities, int n, int x) {
    int count = 0;
    for (int quantity : quantities) {
      count += quantity / x;
      if (quantity % x != 0) {
        count++;
      }
    }
    return count <= n;
  }

}