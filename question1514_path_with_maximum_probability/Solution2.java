package question1514_path_with_maximum_probability;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {

  private static class Pair implements Comparable<Pair> {

    double probability;

    int node;

    public Pair(double probability, int node) {
      this.probability = probability;
      this.node = node;
    }

    public int compareTo(Pair pair) {
      if (this.probability == pair.probability) {
        return this.node - pair.node;
      }
      return this.probability - pair.probability > 0 ? -1 : 1;
    }

  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    List<List<Pair>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      graph.get(edge[0]).add(new Pair(succProb[i], edge[1]));
      graph.get(edge[1]).add(new Pair(succProb[i], edge[0]));
    }
    PriorityQueue<Pair> que = new PriorityQueue<>();
    double[] prob = new double[n];
    que.offer(new Pair(1, start));
    prob[start] = 1;
    while (!que.isEmpty()) {
      Pair pair = que.poll();
      double pr = pair.probability;
      int node = pair.node;
      if (pr < prob[node]) {
        continue;
      }
      for (Pair pairNext : graph.get(node)) {
        double prNext = pairNext.probability;
        int nodeNext = pairNext.node;
        if (prob[nodeNext] < prob[node] * prNext) {
          prob[nodeNext] = prob[node] * prNext;
          que.offer(new Pair(prob[nodeNext], nodeNext));
        }
      }
    }
    return prob[end];
  }

}