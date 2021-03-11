package question1647_minimum_deletions_to_make_character_frequencies_unique;

import java.util.Arrays;

public class Solution {
  public int minDeletions(String s) {
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    Integer[] indexes = new Integer[26];
    for (int i = 0; i < indexes.length; i++) {
      indexes[i] = i;
    }
    Arrays.sort(indexes, (index1, index2) -> map[index2] - map[index1]);
    int result = 0;
    for (int i = 1; i < 26; i++) {
      if (map[indexes[i]] == 0) {
        return result;
      }
      while (map[indexes[i]] >= map[indexes[i - 1]]) {
        map[indexes[i]]--;
        result++;
        if (map[indexes[i]] == 0) {
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().minDeletions("bbcebab"));
  }
}