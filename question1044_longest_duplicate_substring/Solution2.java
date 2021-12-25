package question1044_longest_duplicate_substring;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution2 {

  public String longestDupSubstring(String s) {
    int[] rankArray = getRankArray(s);
    int[] sufArray = getSufArray(rankArray);
    int[] height = getHeight(s, rankArray, sufArray);
    int maxIndex = 0;
    for (int i = 1; i < height.length; i++) {
      if (height[i] > height[maxIndex]) {
        maxIndex = i;
      }
    }
    return s.substring(sufArray[maxIndex], sufArray[maxIndex] + height[maxIndex]);
  }

  private static int[] getSufArray(int[] rankArray) {
    int[] sufArray = new int[rankArray.length];
    for (int i = 0; i < sufArray.length; i++) {
      sufArray[rankArray[i]] = i;
    }
    return sufArray;
  }

  private static int[] getHeight(String s, int[] rankArray, int[] sufArray) {
    int[] height = new int[rankArray.length];
    for (int i = 0; i < height.length; i++) {
      int rank = rankArray[i];
      if (rank > 0) {
        int index1 = sufArray[rank], index2 = sufArray[rank - 1];
        int j = i > 0 ? Math.max(0, height[rankArray[i - 1]] - 1) : 0;
        while (index1 + j < s.length() && index2 + j < s.length() && s.charAt(index1 + j) == s.charAt(index2 + j)) {
          j++;
        }
        height[rank] = j;
      }
    }
    return height;
  }

  private static int[] getRankArray(String s) {
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add((int) s.charAt(i));
    }
    int index = 1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : set) {
      map.put(num, index++);
    }
    int[] rankArray = new int[s.length()];
    for (int i = 0; i < rankArray.length; i++) {
      rankArray[i] = map.get((int) s.charAt(i));
    }
    for (int len = 1; len < s.length(); len *= 2) {
      int[] temp = new int[s.length()];
      for (int i = 0; i < s.length(); i++) {
        temp[i] = rankArray[i] * (s.length() + 1);
        if (i + len < s.length()) {
          temp[i] += rankArray[i + len];
        }
      }
      set.clear();
      map.clear();
      for (int i = 0; i < s.length(); i++) {
        set.add(temp[i]);
      }
      index = 1;
      for (int num : set) {
        map.put(num, index++);
      }
      for (int i = 0; i < temp.length; i++) {
        rankArray[i] = map.get(temp[i]);
      }
    }
    for (int i = 0; i < rankArray.length; i++) {
      rankArray[i]--;
    }
    return rankArray;
  }

}