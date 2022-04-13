package question0218_the_skyline_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Solution {

  private static class Event {
    int x;
    int h;
    boolean isLeft;
  }

  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<Event> events = new ArrayList<>();
    for (int[] building : buildings) {
      Event event1 = new Event();
      event1.x = building[0];
      event1.h = building[2];
      event1.isLeft = true;
      events.add(event1);
      Event event2 = new Event();
      event2.x = building[1];
      event2.h = building[2];
      event2.isLeft = false;
      events.add(event2);
    }
    Collections.sort(events, Comparator.comparingInt(event -> event.x));
    List<List<Integer>> res = new ArrayList<>();
    TreeMap<Integer, Integer> height2Cnt = new TreeMap<>();
    int preHeight = -1;
    for (int i = 0; i < events.size(); ) {
      if (events.get(i).isLeft) {
        height2Cnt.put(events.get(i).h, height2Cnt.getOrDefault(events.get(i).h, 0) + 1);
      } else {
        int origin = height2Cnt.get(events.get(i).h);
        if (origin == 1) {
          height2Cnt.remove(events.get(i).h);
        } else {
          height2Cnt.put(events.get(i).h, origin - 1);
        }
      }
      int j = i + 1;
      while (j < events.size() && events.get(j).x == events.get(i).x) {
        if (events.get(j).isLeft) {
          height2Cnt.put(events.get(j).h, height2Cnt.getOrDefault(events.get(j).h, 0) + 1);
        } else {
          int origin = height2Cnt.get(events.get(j).h);
          if (origin == 1) {
            height2Cnt.remove(events.get(j).h);
          } else {
            height2Cnt.put(events.get(j).h, origin - 1);
          }
        }
        j++;
      }
      // [i, j] 都是相等的已经都处理掉了
      List<Integer> list = new ArrayList<>();
      list.add(events.get(i).x);
      if (height2Cnt.isEmpty()) {
        list.add(0);
      } else {
        list.add(height2Cnt.lastKey());
      }
      if (preHeight != list.get(1)) {
        res.add(list);
      }
      preHeight = list.get(1);
      i = j;
    }
    return res;
  }

}