package question1719_number_of_ways_to_reconstruct_a_tree;

public class Solution {

  public int checkWays(int[][] pairs) {
    int[] relations = new int[501];
    for (int[] pair : pairs) {
      relations[pair[0]]++;
      relations[pair[1]]++;
    }
    int result = 1;
    for (int i = 0; i < relations.length && result == 1; i++) {
      for (int j = i + 1; j < relations.length && result == 1; j++) {
        if (relations[i] != 0 && relations[i] == relations[j]) {
          result = 2;
        }
      }
    }

    return result;
  }

}