package question0729_my_calendar_i;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar3 {

  private List<int[]> list = new ArrayList<>();

  public MyCalendar3() {

  }

  public boolean book(int start, int end) {
    int floorIndex = floor(start), ceilIndex = ceil(start);
    if ((floorIndex == -1 || list.get(floorIndex)[1] <= start)
        && (ceilIndex == list.size() || end <= list.get(ceilIndex)[0])) {
      list.add(ceilIndex, new int[] {start, end});
      return true;
    }
    return false;
  }

  private int floor(int target) {
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (list.get(mid)[0] == target) {
        right = mid - 1;
      } else if (list.get(mid)[0] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < list.size() && list.get(left)[0] == target) {
      return left;
    }
    return right;
  }

  private int ceil(int target) {
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (list.get(mid)[0] == target) {
        left = mid + 1;
      } else if (list.get(mid)[0] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (right >= 0 && list.get(right)[0] == target) {
      return right;
    }
    return left;
  }

}