package question2092;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  private static class UnionFind {

    int[] parent;

    int n;

    int setCount;

    int[] knownTime;

    public UnionFind(int n, int[] knownTime) {
      this.n = n;
      this.setCount = n;
      this.parent = new int[n];
      for (int i = 0; i < n; ++i) {
        parent[i] = i;
      }
      this.knownTime = knownTime;
    }

    public int findParent(int x) {
      int a = x;
      while (x != parent[x]) {
        x = parent[x];
      }
      while (a != parent[a]) {
        int z = parent[a];
        parent[a] = x;
        a = z;
      }
      return x;
    }

    public boolean union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        if (knownTime[aParent] >= knownTime[bParent]) {
          parent[aParent] = bParent;
        } else {
          parent[bParent] = aParent;
        }
        setCount--;
        return true;
      }
      return false;
    }

  }

  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    List<Integer> result = new ArrayList<>(n);
    int[] knownTime = new int[n];
    Arrays.fill(knownTime, Integer.MAX_VALUE);
    knownTime[0] = knownTime[firstPerson] = 0;
    Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[2]));
    for (int i = 0; i < meetings.length; i++) {
      Set<Integer> set = new HashSet<>();
      UnionFind unionFind = new UnionFind(n, knownTime);
      int j = i;
      set.add(meetings[i][0]);
      set.add(meetings[i][1]);
      unionFind.union(meetings[i][0], meetings[i][1]);
      while (j + 1 < meetings.length && meetings[j + 1][2] == meetings[i][2]) {
        set.add(meetings[j + 1][0]);
        set.add(meetings[j + 1][1]);
        unionFind.union(meetings[j + 1][0], meetings[j + 1][1]);
        j++;
      }
      for (int index : set) {
        knownTime[index] = Math.min(knownTime[index], knownTime[unionFind.findParent(index)]);
      }
      i = j;
    }
    for (int i = 0; i < knownTime.length; i++) {
      if (knownTime[i] < Integer.MAX_VALUE) {
        result.add(i);
      }
    }
    return result;
  }

}