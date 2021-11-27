package question1851;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution {

  private static class Event {

    private int type; // 事件的类型：0 表示左端点，1 表示询问，2 表示右端点

    private int pos;  // 事件的位置

    private int param;  // 事件的额外参数：如果是左端点事件，那么 param 记录右端点的位置；如果是询问事件，记录它是第几个询问；如果是右端点事件，记录左端点的位置

    public Event(int type, int pos, int param) {
      this.type = type;
      this.pos = pos;
      this.param = param;
    }

  }

  public int[] minInterval(int[][] intervals, int[] queries) {
    List<Event> eventList = new ArrayList<>(intervals.length + queries.length);
    for (int[] interval : intervals) {
      eventList.add(new Event(0, interval[0], interval[1]));
      eventList.add(new Event(2, interval[1], interval[0]));
    }
    for (int i = 0; i < queries.length; i++) {
      eventList.add(new Event(1, queries[i], i));
    }
    Collections.sort(eventList, (event1, event2) -> {
      if (event1.pos == event2.pos) {
        return event1.type - event2.type;
      }
      return event1.pos - event2.pos;
    });
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int[] result = new int[queries.length];
    Arrays.fill(result, -1);
    for (Event event : eventList) {
      if (event.type == 0) {
        int len = event.param - event.pos + 1;
        treeMap.put(len, treeMap.getOrDefault(len, 0) + 1);
      } else if (event.type == 1) {
        if (!treeMap.isEmpty()) {
          result[event.param] = treeMap.firstKey();
        }
      } else {
        int len = event.pos - event.param + 1;
        Integer origin = treeMap.get(len);
        if (origin == 1) {
          treeMap.remove(len);
        } else {
          treeMap.put(len, origin - 1);
        }
      }
    }
    return result;
  }

}