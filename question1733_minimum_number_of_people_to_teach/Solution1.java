package question1733_minimum_number_of_people_to_teach;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
    int result = Integer.MAX_VALUE;
    Set<Integer>[] languageSet = new HashSet[languages.length];
    for (int i = 0; i < languages.length; i++) {
      languageSet[i] = new HashSet<>();
      for (int j = 0; j < languages[i].length; j++) {
        languageSet[i].add(languages[i][j]);
      }
    }
    for (int i = 1; i <= n; i++) {
      boolean[] learned = new boolean[languages.length];
      int teach = 0;
      for (int[] friendship : friendships) {
        Set<Integer> set1 = languageSet[friendship[0] - 1], set2 = languageSet[friendship[1] - 1];
        if (!canCommunicate(set1, set2)) {
          if (!set1.contains(i) && !learned[friendship[0] - 1]) {
            learned[friendship[0] - 1] = true;
            teach++;
          }
          if (!set2.contains(i) && !learned[friendship[1] - 1]) {
            learned[friendship[1] - 1] = true;
            teach++;
          }
        }
      }
      result = Math.min(result, teach);
    }
    return result;
  }

  private boolean canCommunicate(Set<Integer> set1, Set<Integer> set2) {
    for (int language : set1) {
      if (set2.contains(language)) {
        return true;
      }
    }
    return false;
  }

}