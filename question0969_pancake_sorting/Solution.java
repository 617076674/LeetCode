package question0969_pancake_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> pancakeSort(int[] A) {
    List<Integer> result = new ArrayList<>();
    int N = A.length;
    Integer[] indexes = new Integer[N];
    for (int i = 0; i < N; ++i) {
      indexes[i] = i + 1;
    }
    Arrays.sort(indexes, (i, j) -> A[j - 1] - A[i - 1]);
    for (int i : indexes) {
      for (int f : result) {
        if (i <= f) {
          i = f + 1 - i;
        }
      }
      result.add(i);
      result.add(N--);
    }
    return result;
  }

}