package question1583_count_unhappy_friends;

public class Solution {

  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    int[][] relations = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        relations[i][preferences[i][j]] = j;
      }
    }
    int[] match = new int[n];
    for (int[] pair : pairs) {
      int person0 = pair[0], person1 = pair[1];
      match[person0] = person1;
      match[person1] = person0;
    }
    int result = 0;
    for (int x = 0; x < n; x++) {
      int y = match[x];
      int index = relations[x][y];
      for (int i = 0; i < index; i++) {
        int u = preferences[x][i];
        int v = match[u];
        if (relations[u][x] < relations[u][v]) {
          result++;
          break;
        }
      }
    }
    return result;
  }

}