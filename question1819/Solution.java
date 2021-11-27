package question1819;

public class Solution {

  public int countDifferentSubsequenceGCDs(int[] nums) {
    boolean[] visited = new boolean[200005];
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      visited[num] = true;
      max = Math.max(max, num);
    }
    int result = 0;
    // 公约数可能的范围是 [1, max]
    for (int i = 1; i <= max; i++) {
      int commonGCD = -1;
      // 检查所有 i 的倍数
      for (int j = i; j <= max; j += i) {
        if (visited[j]) {
          commonGCD = commonGCD == -1 ? j : gcd(commonGCD, j);
        }
      }
      if (i == commonGCD) {
        result++;
      }
    }
    return result;
  }

  private static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }

}