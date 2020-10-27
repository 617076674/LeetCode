package question1257_smallest_common_region;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本质：双链表寻找第一个公共节点。
 *
 * 执行用时：22ms，击败17.78%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {

  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    Map<String, Integer> string2Integer = new HashMap<>();
    Map<Integer, String> integer2String = new HashMap<>();
    int index = 0;
    for (List<String> region : regions) {
      for (String name : region) {
        if (!string2Integer.containsKey(name)) {
          string2Integer.put(name, index);
          integer2String.put(index++, name);
        }
      }
    }
    int[] parent = new int[index];
    Arrays.fill(parent, -1);
    for (List<String> region : regions) {
      int p = string2Integer.get(region.get(0));
      for (int i = 1; i < region.size(); i++) {
        parent[string2Integer.get(region.get(i))] = p;
      }
    }
    int begin1 = string2Integer.get(region1), begin2 = string2Integer.get(region2);
    int index1 = begin1, index2 = begin2;
    while (index1 != index2) {
      if (index1 == -1) {
        index1 = begin2;
      } else {
        index1 = parent[index1];
      }
      if (index2 == -1) {
        index2 = begin1;
      } else {
        index2 = parent[index2];
      }
    }
    return integer2String.get(index1);
  }

}