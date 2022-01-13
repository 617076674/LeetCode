package question2127;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private List<Integer>[] parentLists;

  public int maximumInvitations(int[] favorite) {
    // 寻找图中最大的环
    int maxLoopLen = -1;
    boolean[] visited = new boolean[favorite.length];
    List<int[]> list = new ArrayList<>();
    parentLists = new List[favorite.length];
    int[] inDegree = new int[favorite.length], outDegree = new int[favorite.length];
    for (int i = 0; i < favorite.length; i++) {
      inDegree[favorite[i]]++;
      outDegree[i]++;
      if (parentLists[favorite[i]] == null) {
        parentLists[favorite[i]] = new ArrayList<>();
      }
      parentLists[favorite[i]].add(i);
    }
    for (int i = 0; i < favorite.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (inDegree[i] == 0 || outDegree[i] == 0) {
        continue;
      }
      int cur = i;
      int loopLen = 0;
      Integer[] node2Len = new Integer[favorite.length];
      do {
        visited[cur] = true;
        node2Len[cur] = loopLen;
        cur = favorite[cur];
        loopLen++;
      } while (cur != i && !visited[cur]);
      if (cur != i) {
        if (null == node2Len[cur]) {
          continue;
        }
        loopLen -= node2Len[cur];
      }
      // 找到了环
      if (loopLen > maxLoopLen) {
        maxLoopLen = loopLen;
      }
      if (loopLen == 2) {
        list.add(new int[] {cur, favorite[cur]});
      }
    }
    int result = maxLoopLen;
    int another = 0;
    for (int[] temp : list) {
      another += dfs(temp[1], temp[0]) + dfs(temp[0], temp[1]);
    }
    return Math.max(result, another);
  }

  private int dfs(int cur, int another) {
    int result = 1;
    if (parentLists[cur] != null) {
      for (int parent : parentLists[cur]) {
        if (parent != another) {
          result = Math.max(result, 1 + dfs(parent, another));
        }
      }
    }
    return result;
  }

}