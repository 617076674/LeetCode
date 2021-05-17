package question1488_avoid_flood_in_the_city;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

  public int[] avoidFlood(int[] rains) {
    int n = rains.length;
    int[] result = new int[n];
    TreeSet<Integer> zeros = new TreeSet<>();
    Map<Integer, Integer> pool2Day = new HashMap<>(); // 记录下雨的水池->下雨的日子
    for (int i = 0; i < n; i++) {
      if (rains[i] == 0) {
        zeros.add(i);
      } else {
        result[i] = -1;
        int pool = rains[i];
        if (pool2Day.containsKey(pool)) {
          int lastFull = pool2Day.get(pool);
          Integer index = zeros.ceiling(lastFull); // 前一个满了的pool右边的第一个0的index
          if (index != null && index > lastFull) {
            result[index] = pool;
            zeros.remove(index);
            pool2Day.put(pool, i);// 这里要更新当前满了的Pool的index，不能remove，因为虽然把前一个编号为pool的水池放干了，但是现在又下满了
          } else {
            return new int[0];
          }
        } else {
          pool2Day.put(pool, i);
        }
      }
    }
    for (int i : zeros) {
      result[i] = 1;
    }
    return result;
  }

}