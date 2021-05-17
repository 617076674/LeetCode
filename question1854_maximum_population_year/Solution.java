package question1854_maximum_population_year;

public class Solution {

  public int maximumPopulation(int[][] logs) {
    int[] diff = new int[3000];
    for (int[] log : logs) {
      diff[log[0]]++;
      diff[log[1]]--;
    }
    int result = -1, max = 0, temp = 0;
    for (int i = 1950; i <= 2050; i++) {
      temp += diff[i];
      if (temp > max) {
        temp = max;
        result = i;
      }
    }
    return result;
  }

}