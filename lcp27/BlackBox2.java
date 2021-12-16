package lcp27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BlackBox2 {

  // 存储从每个小孔以 y = x 方向射出时，所在的循环的 id 以及在循环中的 id
  private int[][] groupPos;

  // 存储从每个小孔以 y = -x 方向射出时，所在的循环的 id 以及在循环中的 id
  private int[][] groupNeg;

  // 存储每个循环的有序映射
  private List<TreeMap<Integer, Integer>> groupStats = new ArrayList<>();

  public BlackBox2(int n, int m) {
    int ptCount = (m + n) * 2;
    groupPos = new int[ptCount][2];
    for (int[] group : groupPos) {
      Arrays.fill(group, -1);
    }
    groupNeg = new int[ptCount][2];
    for (int[] group : groupNeg) {
      Arrays.fill(group, -1);
    }
    for (int i = 0; i < ptCount; i++) {
      if (i != 0 && i != m + n && groupPos[i][0] == -1) {
        createGroup(n, m, i, 1);
      }
      if (i != m && i != 2 * m + n && groupNeg[i][0] == -1) {
        createGroup(n, m, i, -1);
      }
    }
  }

  private void createGroup(int n, int m, int index, int direction) {
    int groupId = groupStats.size();
    int groupLoc = 0;
    groupStats.add(new TreeMap<>());
    // 不断模拟光线的路径，直到走到一个已经遇见过的状态，这样就找到了一个循环
    while (!(direction == 1 && groupPos[index][0] != -1) && !(direction == -1 && groupNeg[index][0] != -1)) {
      if (direction == 1) {
        groupPos[index][0] = groupId;
        groupPos[index][1] = groupLoc++;
        index = (m + n) * 2 - index;
      } else {
        groupNeg[index][0] = groupId;
        groupNeg[index][1] = groupLoc++;
        if (index <= 2 * m) {
          index = 2 * m - index;
        } else {
          index = (2 * m + n) * 2 - index;
        }
      }
      // 如果小孔不在角上，就改变方向
      if (index != 0 && index != m && index != m + n && index != 2 * m + n) {
        direction = -direction;
      }
    }
  }

  public int open(int index, int direction) {
    // 插入二元组
    if (groupPos[index][0] != -1) {
      groupStats.get(groupPos[index][0]).put(groupPos[index][1], index);
    }
    if (groupNeg[index][0] != -1) {
      groupStats.get(groupNeg[index][0]).put(groupNeg[index][1], index);
    }
    int[] groupIdAndGroupLoc = direction == 1 ? groupPos[index] : groupNeg[index];
    // 查询
    TreeMap<Integer, Integer> store = groupStats.get(groupIdAndGroupLoc[0]);
    Map.Entry<Integer, Integer> entry = store.ceilingEntry(groupIdAndGroupLoc[1] + 1);
    if (null != entry) {
      return entry.getValue();
    }
    return store.firstEntry().getValue();
  }

  public void close(int index) {
    if (groupPos[index][0] != -1) {
      groupStats.get(groupPos[index][0]).remove(groupPos[index][1]);
    }
    if (groupNeg[index][0] != -1) {
      groupStats.get(groupNeg[index][0]).remove(groupNeg[index][1]);
    }
  }

}