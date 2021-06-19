package question1899_merge_triplets_to_form_target_triplet;

import java.util.Arrays;

public class Solution {

  public boolean mergeTriplets(int[][] triplets, int[] target) {
    int[] result = new int[3];
    for (int[] triplet : triplets) {
      if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
        for (int i = 0; i < 3; i++) {
          result[i] = Math.max(result[i], triplet[i]);
        }
      }
    }
    return Arrays.equals(target, result);
  }

}