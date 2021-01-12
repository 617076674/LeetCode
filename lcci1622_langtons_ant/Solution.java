package lcci1622_langtons_ant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<String> printKMoves(int K) {
    char[] directions = {'L', 'U', 'R', 'D'};
    Map<Long, Boolean> map = new HashMap<>();
    int x = 0, y = 0;
    int directionIndex = 2;
    for (int i = 0; i < K; i++) {
      long key = generateKey(x, y);
      if (!map.containsKey(key) || map.get(key)) {
        map.put(key, false);
        directionIndex = (directionIndex + 1) % 4;
      } else {
        map.put(key, true);
        directionIndex = (directionIndex + 3) % 4;
      }
      // 3. 向前移动一个单位
      if (directionIndex == 0) {
        y--;
      } else if (directionIndex == 1) {
        x--;
      } else if (directionIndex == 2) {
        y++;
      } else {
        x++;
      }
    }
    map.put(generateKey(x, y), true);
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
    for (long key : map.keySet()) {
      int tmpX = (int) (key / 200001L - 100000L);
      int tmpY = (int) (key % 200001L - 100000L);
      minX = Math.min(minX, tmpX);
      maxX = Math.max(maxX, tmpX);
      minY = Math.min(minY, tmpY);
      maxY = Math.max(maxY, tmpY);
    }
    List<String> result = new ArrayList<>();
    for (int i = minX; i <= maxX; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = minY; j <= maxY; j++) {
        if (i == x && j == y) {
          sb.append(directions[directionIndex]);
        } else {
          long key = generateKey(i, j);
          if (map.getOrDefault(key, true)) {
            sb.append('_');
          } else {
            sb.append('X');
          }
        }
      }
      result.add(sb.toString());
    }
    return result;
  }

  private static long generateKey(int x, int y) {
    return (100000L + x) * 200001L + (y + 100000L);
  }

}