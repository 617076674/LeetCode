package question2186;

public class Solution {

  public int minSteps(String s, String t) {
    int[] map1 = getMap(s), map2 = getMap(t);
    int result = 0;
    for (int i = 0; i < 26; i++) {
      int max = Math.max(map1[i], map2[i]);
      int min = Math.min(map1[i], map2[i]);
      result += max - min;
    }
    return result;
  }

  private int[] getMap(String s) {
    int[] result = new int[26];
    for (int i = 0; i < s.length(); i++) {
      result[s.charAt(i) - 'a']++;
    }
    return result;
  }

}