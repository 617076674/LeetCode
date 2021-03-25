package question0729_my_calendar_i;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar1 {

  private List<int[]> list = new ArrayList<>();

  public MyCalendar1() {

  }

  public boolean book(int start, int end) {
    int index = findInsertionPlace(start, end);
    if (index == -1) {
      return false;
    }
    if (index == list.size()) {
      list.add(new int[] {start, end});
    } else {
      list.add(index, new int[] {start, end});
    }
    return true;
  }

  private int findInsertionPlace(int start, int end) {
    if (list.isEmpty()) {
      return 0;
    }
    if (end <= list.get(0)[0]) {
      return 0;
    }
    if (start >= list.get(list.size() - 1)[1]) {
      return list.size();
    }
    for (int i = 0; i < list.size(); i++) {
      if (start >= list.get(i)[1] && (i + 1 < list.size() && list.get(i + 1)[0] >= end)) {
        return i + 1;
      }
    }
    return -1;
  }

}