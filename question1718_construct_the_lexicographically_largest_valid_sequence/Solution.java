package question1718_construct_the_lexicographically_largest_valid_sequence;

public class Solution {

  private int[] result;

  private boolean[] visited;

  public int[] constructDistancedSequence(int n) {
    result = new int[2 * n - 1];
    visited = new boolean[n];
    try {
      fill(0);
    } catch (Exception e) {

    }
    return result;
  }

  private void fill(int index) {
    if (index == result.length) {
      throw new RuntimeException();
    }
    for (int i = visited.length - 1; i >= 0; i--) {
      if (!visited[i]) {
        if (i == 0) {
          if (result[index] == 0) {
            visited[i] = true;
            result[index] = 1;
            int temp = index;
            while (temp + 1 < result.length && result[temp + 1] != 0) {
              temp++;
            }
            fill(temp + 1);
            result[index] = 0;
            visited[i] = false;
          }
        } else {
          if (result[index] == 0 && index + i + 1 < result.length && result[index + i + 1] == 0) {
            visited[i] = true;
            result[index] = result[index + i + 1] = i + 1;
            int temp = index;
            while (temp + 1 < result.length && result[temp + 1] != 0) {
              temp++;
            }
            fill(temp + 1);
            result[index] = result[index + i + 1] = 0;
            visited[i] = false;
          }
        }
      }
    }
  }

}