package question1996;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, Comparator.comparingInt(p -> p[0]));
    int maxDefence = -1, result = 0;
    for (int i = properties.length - 1; i >= 0; ) {
      int tempMaxDefence = -1;
      int j = i;
      while (j >= 0 && properties[j][0] == properties[i][0]) {
        if (properties[j][1] < maxDefence) {
          result++;
        }
        tempMaxDefence = Math.max(tempMaxDefence, properties[j][1]);
        j--;
      }
      maxDefence = Math.max(maxDefence, tempMaxDefence);
      i = j;
    }
    return result;
  }

}