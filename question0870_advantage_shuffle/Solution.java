package question0870_advantage_shuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

  public int[] advantageCount(int[] A, int[] B) {
    int[] sortedA = A.clone();
    Arrays.sort(sortedA);
    int[] sortedB = B.clone();
    Arrays.sort(sortedB);

    // assigned[b] = list of a that are assigned to beat b
    Map<Integer, LinkedList<Integer>> assigned = new HashMap<>();
    for (int b : B) {
      assigned.put(b, new LinkedList<>());
    }

    // remaining = list of a that are not assigned to any b
    LinkedList<Integer> remaining = new LinkedList<>();

    // populate (assigned, remaining) appropriately
    // sortedB[j] is always the smallest unassigned element in B
    int j = 0;
    for (int a : sortedA) {
      if (a > sortedB[j]) {
        assigned.get(sortedB[j++]).add(a);
      } else {
        remaining.add(a);
      }
    }

    // Reconstruct the answer from annotations (assigned, remaining)
    int[] result = new int[B.length];
    for (int i = 0; i < B.length; i++) {
      // if there is some a assigned to b...
      if (!assigned.get(B[i]).isEmpty()) {
        result[i] = assigned.get(B[i]).pop();
      } else {
        result[i] = remaining.pop();
      }
    }
    return result;
  }

}