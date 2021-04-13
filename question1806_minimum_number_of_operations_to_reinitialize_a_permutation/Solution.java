package question1806_minimum_number_of_operations_to_reinitialize_a_permutation;

public class Solution {
  
  public int reinitializePermutation(int n) {
    int[] perm = new int[n];
    for (int i = 0; i < n; i++) {
      perm[i] = i;
    }
    int step = 1;
    while (true) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          arr[i] = perm[i / 2];
        } else {
          arr[i] = perm[n / 2 + (i - 1) / 2];
        }
      }
      boolean flag = true;
      for (int i = 0; i < n; i++) {
        if (arr[i] != i) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return step;
      }
      step++;
      perm = arr;
    }
  }

}