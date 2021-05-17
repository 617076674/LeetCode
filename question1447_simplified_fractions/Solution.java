package question1447_simplified_fractions;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> simplifiedFractions(int n) {
    List<String> result = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        if (gcd(j, i) == 1) {
          result.add(j + "/" + i);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.simplifiedFractions(2));
    System.out.println(solution.simplifiedFractions(3));
    System.out.println(solution.simplifiedFractions(4));
    System.out.println(solution.simplifiedFractions(1));
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

}