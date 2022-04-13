package question2203;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

  private int idx;

  private static final int N = 100010;

  private static final int M = 200010;

  private int[] h = new int[N];

  private int[] rh = new int[N];

  private int[] e = new int[M];

  private int[] w = new int[M];

  private int[] ne = new int[M];

  private int n;

  private void add(int[] h, int a, int b, int l) {
    e[idx] = b;
    w[idx] = l;
    ne[idx] = h[a];
    h[a] = idx++;
  }

  private static class DijkstraNode implements Comparable<DijkstraNode> {
    int node;
    long distance;

    public DijkstraNode(int node, long distance) {
      this.node = node;
      this.distance = distance;
    }

    @Override
    public int compareTo(DijkstraNode o) {
      if (o.distance < this.distance) {
        return 1;
      }
      if (o.distance > this.distance) {
        return -1;
      }
      return 0;
    }
  }

  private long[] dijkstra(int[] h, int start) {
    long[] dist = new long[n];
    Arrays.fill(dist, MAX);
    dist[start] = 0;
    int[] st = new int[n];
    PriorityQueue<DijkstraNode> heap = new PriorityQueue<>();
    heap.add(new DijkstraNode(start, 0));
    while (!heap.isEmpty()) {
      DijkstraNode cur = heap.poll();
      int ver = cur.node;
      long distance = cur.distance;
      if (st[ver] > 0) {
        continue;
      }
      st[ver]++;
      for (int i = h[ver]; i != -1; i = ne[i]) {
        int j = e[i];
        if (distance + w[i] < dist[j]) {
          dist[j] = distance + w[i];
          heap.add(new DijkstraNode(j, dist[j]));
        }
      }
    }
    return dist;
  }

  private static final long MAX = Long.MAX_VALUE / 4;

  public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
    this.n = n;
    Arrays.fill(h, -1);
    Arrays.fill(rh, -1);
    for (int[] edge : edges) {
      add(h, edge[0], edge[1], edge[2]);
      add(rh, edge[1], edge[0], edge[2]);
    }
    long[] distance1 = dijkstra(h, src1);
    long[] distance2 = dijkstra(h, src2);
    long[] distance3 = dijkstra(rh, dest);
    long result = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      result = Math.min(result, distance1[i] + distance2[i] + distance3[i]);
    }
    return result >= MAX ? -1 : result;
  }

}