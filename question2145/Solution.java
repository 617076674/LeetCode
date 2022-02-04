package question2145;

public class Solution {

  public int numberOfArrays(int[] differences, int lower, int upper) {
    long cur = 0, max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    for (int i = 0; i < differences.length; i++) {
      cur += differences[i];
      max = Math.max(max, cur);
      min = Math.min(min, cur);
    }
    long maxBegin = upper - max;
    long minBegin = lower - min;
    if (maxBegin < minBegin) {
      return 0;
    }
    if (lower > upper) {
      return 0;
    }
    long left = Math.max(minBegin, lower);
    long right = Math.min(upper, maxBegin);
    if (left > right) {
      return 0;
    }
    return (int) (right - left + 1);
  }

}