package question1737_change_minimum_characters_to_satisfy_one_of_three_conditions;

public class Solution {

  public int minCharacters(String a, String b) {
    int[] map = getMap(a + b);
    int max = Integer.MIN_VALUE;
    for (int cnt : map) {
      max = Math.max(max, cnt);
    }
    int[] mapA = getMap(a), mapB = getMap(b);
    return Math.min(a.length() + b.length() - max,
        Math.min(minCharactersHelper(mapA, mapB), minCharactersHelper(mapB, mapA)));
  }

  private static int minCharactersHelper(int[] mapA, int[] mapB) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 25; i++) {
      int adjust = 0;
      for (int j = i + 1; j < 26; j++) {
        adjust += mapA[j];
      }
      for (int j = 0; j <= i; j++) {
        adjust += mapB[j];
      }
      result = Math.min(result, adjust);
    }
    return result;
  }

  private static int[] getMap(String s) {
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    return map;
  }

}