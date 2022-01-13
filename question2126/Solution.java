package question2126;

import java.util.Arrays;

public class Solution {

  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    Arrays.sort(asteroids);
    long temp = mass;
    for (int i = 0; i < asteroids.length; i++) {
      if (temp >= asteroids[i]) {
        temp += asteroids[i];
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int mass = 5;
    int[] asteroids = {4,9,23,4};
    System.out.println(new Solution().asteroidsDestroyed(mass, asteroids));
  }

}
