package question2122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int[] recoverArray(int[] nums) {
    Arrays.sort(nums);
    Map<Integer, Integer> num2Cnt = new HashMap<>();
    Map<Integer, Set<Integer>> num2Indexes = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
      Set<Integer> set = num2Indexes.get(num);
      if (null == set) {
        set = new HashSet<>();
        set.add(i);
        num2Indexes.put(num, set);
      } else {
        set.add(i);
      }
    }
    int n = nums.length / 2;
    int[] gap = new int[n];
    int numsIndex = nums.length - 1;
    int gapIndex = n - 1;
    while (numsIndex - 1 >= 0) {
      if ((nums[nums.length - 1] - nums[numsIndex - 1]) % 2 == 0 && nums[nums.length - 1] - nums[numsIndex - 1] != 0) {
        Map<Integer, Set<Integer>> tempNum2Indexes = new HashMap<>(num2Indexes);
        for (Map.Entry<Integer, Set<Integer>> entry : num2Indexes.entrySet()) {
          tempNum2Indexes.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
        int k = (nums[nums.length - 1] - nums[numsIndex - 1]) / 2;
        boolean[] visited = new boolean[nums.length];
        boolean flag = true;
        int[] result = new int[n];
        int resultIdx = 0;
        for (int i = 0; i < nums.length; i++) {
          if (visited[i]) {
            continue;
          }
          Set<Integer> set = num2Indexes.get(nums[i] + 2 * k);
          if (null == set || set.isEmpty()) {
            flag = false;
            num2Indexes = tempNum2Indexes;
            break;
          }
          visited[i] = true;
          int index2 = set.iterator().next();
          set.remove(index2);
          visited[index2] = true;
          result[resultIdx++] = nums[i] + k;
        }
        if (flag) {
          return result;
        }
      }
      gap[gapIndex] = nums[numsIndex] - nums[numsIndex - 1];
      gapIndex--;
      if (gapIndex == 0) {
        break;
      }
      numsIndex--;
    }
    long sums = 0;
    for (int num : nums) {
      sums += num;
    }
    sums /= 2;
    long gapSum = 0;
    int[] tmpGap = new int[gap.length];
    System.arraycopy(gap, 0, tmpGap, 0, gap.length);
    for (int i = 1; i < gap.length; i++) {
      tmpGap[i] += tmpGap[i - 1];
    }
    for (int gapValue : tmpGap) {
      gapSum += gapValue;
    }
    int a = (int) ((sums - gapSum) / n);
    int[] result = new int[n];
    result[0] = a;
    for (int i = 1; i < n; i++) {
      result[i] = result[i - 1] + gap[i];
    }
    return result;
  }

}
