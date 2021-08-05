package question1943_describe_the_painting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  public List<List<Long>> splitPainting(int[][] segments) {
    Map<Long, Long> map = new TreeMap<>();
    for (int[] segment : segments) {
      map.put((long) segment[0], map.getOrDefault((long) segment[0], 0L) + segment[2]);
      map.put((long) segment[1], map.getOrDefault((long) segment[1], 0L) - segment[2]);
    }
    List<List<Long>> result = new ArrayList<>();
    long value = 0;
    Map.Entry<Long, Long> pre = null;
    for (Map.Entry<Long, Long> entry : map.entrySet()) {
      if (pre != null && value > 0) {
        List<Long> list = new ArrayList<>();
        list.add(pre.getKey());
        list.add(entry.getKey());
        list.add(value);
        result.add(list);
      }
      pre = entry;
      value += entry.getValue();
    }
    return result;
  }

}