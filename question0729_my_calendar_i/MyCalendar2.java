package question0729_my_calendar_i;

import java.util.TreeMap;

public class MyCalendar2 {

  private TreeMap<Integer, Integer> calendar = new TreeMap<>();

  MyCalendar2() {
  }

  public boolean book(int start, int end) {
    Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
    if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }

}