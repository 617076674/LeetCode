package question1222_queens_that_can_attack_the_king;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    boolean[][] graph = new boolean[8][8];
    for (int[] queen : queens) {
      graph[queen[0]][queen[1]] = true;
    }
    List<List<Integer>> result = new ArrayList<>();
    int[][] directions = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
      for (int[] direction : directions) {
          int i = 0;
          while (true) {
              int nextX = king[0] + i * direction[0], nextY = king[1] + i * direction[1];
              if (nextX >= 0 && nextX < 8 && nextY >= 0 && nextY < 8) {
                  if (graph[nextX][nextY]) {
                      List<Integer> list = new ArrayList<>();
                      list.add(nextX);
                      list.add(nextY);
                      result.add(list);
                      break;
                  }
              } else {
                  break;
              }
              i++;
          }
      }
      return result;
  }

}