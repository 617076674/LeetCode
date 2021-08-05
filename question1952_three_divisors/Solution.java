package question1952_three_divisors;

public class Solution {

  public boolean isThree(int n) {
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        if (result == 3) {
          return false;
        }
        result++;
      }
    }
    return result == 3;
  }

}