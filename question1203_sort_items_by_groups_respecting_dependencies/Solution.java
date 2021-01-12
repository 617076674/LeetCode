package question1203_sort_items_by_groups_respecting_dependencies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    List<List<Integer>> groupItem = new ArrayList<>();
    for (int i = 0; i < n + m; i++) {
      groupItem.add(new ArrayList<>());
    }

    // 组间和组内依赖图
    List<List<Integer>> groupGraph = new ArrayList<>();
    for (int i = 0; i < n + m; i++) {
      groupGraph.add(new ArrayList<>());
    }
    List<List<Integer>> itemGraph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      itemGraph.add(new ArrayList<>());
    }

    // 组间和组内入度数组
    int[] groupDegree = new int[n + m];
    int[] itemDegree = new int[n];

    List<Integer> id = new ArrayList<>();
    for (int i = 0; i < n + m; i++) {
      id.add(i);
    }

    int leftId = m;
    // 给未分配的 item 分配一个 groupId
    for (int i = 0; i < n; i++) {
      if (group[i] == -1) {
        group[i] = leftId++;
      }
      groupItem.get(group[i]).add(i);
    }
    // 依赖关系建图
    for (int i = 0; i < n; ++i) {
      int curGroupId = group[i];
      for (int item : beforeItems.get(i)) {
        int beforeGroupId = group[item];
        if (beforeGroupId == curGroupId) {
          itemDegree[i]++;
          itemGraph.get(item).add(i);
        } else {
          groupDegree[curGroupId]++;
          groupGraph.get(beforeGroupId).add(curGroupId);
        }
      }
    }

    // 组间拓扑关系排序
    List<Integer> groupTopSort = topSort(groupDegree, groupGraph, id);
    if (groupTopSort.isEmpty()) {
      return new int[0];
    }
    int[] result = new int[n];
    int index = 0;
    // 组内拓扑关系排序
    for (int curGroupId : groupTopSort) {
      int size = groupItem.get(curGroupId).size();
      if (size == 0) {
        continue;
      }
      List<Integer> res = topSort(itemDegree, itemGraph, groupItem.get(curGroupId));
      if (res.isEmpty()) {
        return new int[0];
      }
      for (int item : res) {
        result[index++] = item;
      }
    }
    return result;
  }

  public List<Integer> topSort(int[] deg, List<List<Integer>> graph, List<Integer> items) {
    Queue<Integer> queue = new LinkedList<>();
    for (int item : items) {
      if (deg[item] == 0) {
        queue.offer(item);
      }
    }
    List<Integer> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int u = queue.poll();
      res.add(u);
      for (int v : graph.get(u)) {
        if (--deg[v] == 0) {
          queue.offer(v);
        }
      }
    }
    return res.size() == items.size() ? res : new ArrayList<>();
  }

}