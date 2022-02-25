package lcp46;

import java.util.Arrays;

public class Solution {

  private int[] h, ne, e;

  private int edgeIdx;

  private static final int MAX_EDGE_CNT = 100010;

  private void add(int a, int b) {
    e[edgeIdx] = b;
    ne[edgeIdx] = h[a];
    h[a] = edgeIdx++;
  }

  public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
    int n = finalCnt.length + 1;
    h = new int[n];
    Arrays.fill(h, -1);
    ne = new int[MAX_EDGE_CNT];
    e = new int[MAX_EDGE_CNT];
    for (int[] edge : edges) {
      add(edge[0], edge[1]);
      add(edge[1], edge[0]);
    }
    long[][] completeFinalCnt = new long[n][2];
    completeFinalCnt[0][0] = 1; // x 的系数
    completeFinalCnt[0][1] = 0; // 常数
    for (int i = 0; i < finalCnt.length; i++) {
      completeFinalCnt[i + 1][0] = 0;
      completeFinalCnt[i + 1][1] = finalCnt[i];
    }
    for (int i = plans.length - 1; i >= 0; i--) {
      int choice = plans[i][0];
      int idx = plans[i][1];
      if (choice == 1) {
        // idx 处的值翻倍
        completeFinalCnt[idx][0] *= 2;
        completeFinalCnt[idx][1] *= 2;
      } else if (choice == 2) {
        for (int j = h[idx]; j != -1; j = ne[j]) {
          completeFinalCnt[e[j]][0] -= completeFinalCnt[idx][0];
          completeFinalCnt[e[j]][1] -= completeFinalCnt[idx][1];
        }
      } else if (choice == 3) {
        for (int j = h[idx]; j != -1; j = ne[j]) {
          completeFinalCnt[e[j]][0] += completeFinalCnt[idx][0];
          completeFinalCnt[e[j]][1] += completeFinalCnt[idx][1];
        }
      }
    }
    long cntX = 0, cntConstant = 0;
    for (int i = 0; i < n; i++) {
      cntX += completeFinalCnt[i][0];
      cntConstant += completeFinalCnt[i][1];
    }
    long x = (totalNum - cntConstant) / cntX;
    // 最终 x 的值
    long[] finalStatus = new long[n];
    finalStatus[0] = x;
    for (int i = 1; i < n; i++) {
      finalStatus[i] = finalCnt[i - 1];
    }
    for (int i = plans.length - 1; i >= 0; i--) {
      int choice = plans[i][0];
      int idx = plans[i][1];
      if (choice == 1) {
        // idx 处的值翻倍
        finalStatus[idx] *= 2;
      } else if (choice == 2) {
        for (int j = h[idx]; j != -1; j = ne[j]) {
          finalStatus[e[j]] -= finalStatus[idx];
        }
      } else if (choice == 3) {
        for (int j = h[idx]; j != -1; j = ne[j]) {
          finalStatus[e[j]] += finalStatus[idx];
        }
      }
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = (int) finalStatus[i];
    }
    return result;
  }

}