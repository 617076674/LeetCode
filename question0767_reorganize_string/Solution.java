package question0767_reorganize_string;

import java.util.PriorityQueue;

public class Solution {

  public String reorganizeString(String S) {
    int[] map = new int[26];
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      map[c - 'a']++;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((index1, index2) -> map[index2] - map[index1]);
    for (int i = 0; i < map.length; i++) {
      if (map[i] > 0) {
        pq.add(i);
      }
    }
    char[] array = new char[S.length()];
    int i = 0;
    while (!pq.isEmpty()) {
      int index = pq.poll();
      int begin = i;
      boolean flag = true;
      while (map[index] > 0) {
        if (!Character.isLetter(array[i]) && (i == 0 || array[i - 1] != (char) (index + 'a'))) {
          array[i] = (char) (index + 'a');
          map[index]--;
          flag = false;
        }
        i++;
        if (i == array.length) {
          i = 0;
        }
        if (i == begin) {
          if (flag) {
            return "";
          } else {
            flag = true;
          }
        }
      }
      if (map[index] > 0) {
        return "";
      }
    }
    return new String(array);
  }

}