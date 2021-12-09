package question2094;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public int[] findEvenNumbers(int[] digits) {
    Set<Integer> resultSet = new HashSet<>();
    for (int i = 0; i < digits.length; i++) {
      for (int j = 0; j < digits.length; j++) {
        for (int k = 0; k < digits.length; k++) {
          if (i != j && i != k && k != j && digits[i] != 0 && (digits[k] & 1) == 0) {
            resultSet.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
          }
        }
      }
    }
    List<Integer> resultList = new ArrayList<>(resultSet);
    Collections.sort(resultList);
    int[] result = new int[resultList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }

}