package question0731_my_calendar_ii;

import java.util.TreeMap;

/**
 * 差分数组。
 */
public class MyCalendarTwo {

  private TreeMap<Integer, Integer> delta = new TreeMap<>();

  public MyCalendarTwo() {
  }

  public boolean book(int start, int end) {
    delta.put(start, delta.getOrDefault(start, 0) + 1);
    delta.put(end, delta.getOrDefault(end, 0) - 1);
    int active = 0;
    for (int d: delta.values()) {
      active += d;
      if (active >= 3) {
        delta.put(start, delta.get(start) - 1);
        delta.put(end, delta.get(end) + 1);
        if (delta.get(start) == 0)
          delta.remove(start);
        return false;
      }
    }
    return true;
  }

}