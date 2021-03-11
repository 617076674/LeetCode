package question1733_minimum_number_of_people_to_teach;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
    Set<Integer>[] languageSet = new HashSet[languages.length];
    for (int i = 0; i < languages.length; i++) {
      languageSet[i] = new HashSet<>();
      for (int j = 0; j < languages[i].length; j++) {
        languageSet[i].add(languages[i][j]);
      }
    }
    Set<Integer> canNotCommunicate = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] friendship : friendships) {
      Set<Integer> set1 = languageSet[friendship[0] - 1], set2 = languageSet[friendship[1] - 1];
      if (!canCommunicate(set1, set2)) {
        if (!canNotCommunicate.contains(friendship[0])) {
          canNotCommunicate.add(friendship[0]);
          for (int language : set1) {
            map.put(language, map.getOrDefault(language, 0) + 1);
          }
        }
        if (!canNotCommunicate.contains(friendship[1])) {
          canNotCommunicate.add(friendship[1]);
          for (int language : set2) {
            map.put(language, map.getOrDefault(language, 0) + 1);
          }
        }
      }
    }
    int max = 0;
    for (int count : map.values()) {
      max = Math.max(max, count);
    }
    return canNotCommunicate.size() - max;
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
