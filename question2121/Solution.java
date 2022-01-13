package question2121;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public long[] getDistances(int[] arr) {
    Map<Integer, Integer> num2Cnt = new HashMap<>();
    Map<Integer, Integer> num2PreIndex = new HashMap<>();
    Map<Integer, Long> num2Result = new HashMap<>();
    long[] result = new long[arr.length];
    for (int i = 0; i < arr.length; i++) {
      Integer preIndex = num2PreIndex.get(arr[i]);
      if (null != preIndex) {
        num2Result.put(arr[i], num2Result.getOrDefault(arr[i], 0L) + (i - preIndex) * 1L * num2Cnt.getOrDefault(arr[i], 0));
        result[i] += num2Result.get(arr[i]);
      }
      num2Cnt.put(arr[i], num2Cnt.getOrDefault(arr[i], 0) + 1);
      num2PreIndex.put(arr[i], i);
    }
    num2Cnt = new HashMap<>();
    num2PreIndex = new HashMap<>();
    num2Result = new HashMap<>();
    for (int i = arr.length - 1; i >= 0; i--) {
      Integer preIndex = num2PreIndex.get(arr[i]);
      if (null != preIndex) {
        num2Result.put(arr[i], num2Result.getOrDefault(arr[i], 0L) + (preIndex - i) * 1L * num2Cnt.getOrDefault(arr[i], 0));
        result[i] += num2Result.get(arr[i]);
      }
      num2Cnt.put(arr[i], num2Cnt.getOrDefault(arr[i], 0) + 1);
      num2PreIndex.put(arr[i], i);
    }
    return result;
  }

}