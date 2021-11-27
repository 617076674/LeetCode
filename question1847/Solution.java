package question1847;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Solution {

  private static class Event {

    private int type;   // 事件的类型，0 表示房间，1 表示询问

    private int size;   // 房价的 size 或者询问的 minSize

    private int id; // 房间的 id 或者询问的 preferred

    private int origin; // 房间在数组 room 中的原始编号或者询问在 queries 中的原始编号

    public Event(int type, int size, int id, int origin) {
      this.type = type;
      this.size = size;
      this.id = id;
      this.origin = origin;
    }

  }

  public int[] closestRoom(int[][] rooms, int[][] queries) {
      List<Event> eventList = new ArrayList<>(rooms.length + queries.length);
      for (int i = 0; i < rooms.length; i++) {
          eventList.add(new Event(0, rooms[i][1], rooms[i][0], i));
      }
      for (int i = 0; i < queries.length; i++) {
          eventList.add(new Event(1, queries[i][1], queries[i][0], i));
      }
      Collections.sort(eventList, (event1, event2) -> event2.size - event1.size);
      int[] result = new int[queries.length];
      Arrays.fill(result, -1);
      TreeSet<Integer> roomIdSet = new TreeSet<>(); // 存储房间 roomId 的有序集合
      for (Event event : eventList) {
          if (event.type == 0) {
              roomIdSet.add(event.id);
          } else {
              int distance = Integer.MAX_VALUE;
              Integer ceilId = roomIdSet.ceiling(event.id);
              if (null != ceilId) {
                distance = Math.min(distance, ceilId - event.id);
                result[event.origin] = ceilId;
              }
              Integer floorId = roomIdSet.floor(event.id);
              if (null != floorId && event.id - floorId <= distance) {
                result[event.origin] = floorId;
              }
          }
      }
      return result;
  }

}