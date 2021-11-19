package question2007_find_original_array_from_doubled_array;

public class Solution {

  public int[] findOriginalArray(int[] changed) {
    if ((changed.length & 1) == 1) {
      return new int[0];
    }
    int[] map = new int[100001];
    for (int num : changed) {
      map[num]++;
    }
    int[] result = new int[changed.length / 2];
    int index = 0;
    for (int i = 0; i < map.length; i++) {
      if (i == 0) {
        index += map[i] / 2;
        map[i] %= 2;
      } else {
        while (map[i] > 0 && i * 2 < 100001 && map[i * 2] > 0) {
          result[index++] = i;
          map[i]--;
          map[i * 2]--;
        }
      }
    }
    if (index < result.length) {
      return new int[0];
    }
    return result;
  }

}