package question1551_minimum_operations_to_make_array_equal;

public class Solution {

  public int minOperations(int n) {
    int half = n / 2;
    return n * half - (2 * (half - 1) + 2) * half / 2;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minOperations(3));
    System.out.println(solution.minOperations(6));
  }

}