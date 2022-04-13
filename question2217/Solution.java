package question2217;

import java.util.Arrays;

public class Solution {

  private int intLength;

  private int[] num;

  public long[] kthPalindrome(int[] queries, int intLength) {
    this.intLength = intLength;
    long[] res = new long[queries.length];
    for (int i = 0; i < queries.length; i++) {
      num = new int[intLength];
      res[i] = query(0, queries[i] - 1);
    }
    return res;
  }

  private long query(int index, int query) {
    if (index == (intLength - 1) / 2) {
      if (index == 0) {
        if (query <= 8) {
          num[index] = num[num.length - index - 1] = query + 1;
          return array2Long();
        }
        return -1;
      }
      if (query <= 9) {
        num[index] = num[num.length - index - 1] = query;
        return array2Long();
      }
      return -1;
    }
    if (index > (intLength - 1) / 2) {
      return -1;
    }
    if (query == 0) {
      // 寻找第一个
      if (index == 0) {
        num[0] = num[num.length - 1] = 1;
        return array2Long();
      }
      return array2Long();
    }
    int choice = (intLength + 1) / 2 - index - 1;
    int choiceNum = (int) (query / Math.pow(10, choice));
    if (index == 0) {
      if (choiceNum > 8) {
        return -1;
      }
      num[index] = num[num.length - 1 - index] = choiceNum + 1;
    } else {
      if (choiceNum > 9) {
        return -1;
      }
      num[index] = num[num.length - 1 - index] = choiceNum;
    }
    return query(index + 1, (int) (query - choiceNum * Math.pow(10, choice)));
  }

  private long array2Long() {
    long res = 0L;
    for (int i = 0; i < num.length; i++) {
      res = res * 10 + num[i];
    }
    return res;
  }

}