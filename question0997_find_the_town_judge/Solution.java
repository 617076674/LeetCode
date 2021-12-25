package question0997_find_the_town_judge;

public class Solution {

  public int findJudge(int N, int[][] trust) {
    int[] outDegrees = new int[N + 1], inDegrees = new int[N + 1];
    for (int[] edge : trust) {
      outDegrees[edge[0]]++;
      inDegrees[edge[1]]++;
    }
    int result = -1;
    for (int i = 1; i <= N; i++) {
      if (outDegrees[i] == 0 && inDegrees[i] == N - 1) {
        if (result != -1) {
          return -1;
        }
        result = i;
      }
    }
    return result;
  }

}