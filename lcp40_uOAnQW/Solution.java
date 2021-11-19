package lcp40_uOAnQW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public int maxmiumScore(int[] cards, int cnt) {
    List<Integer> evenList = new ArrayList<>(), oddList = new ArrayList<>();
    for (int card : cards) {
      if ((card & 1) == 0) {
        evenList.add(card);
      } else {
        oddList.add(card);
      }
    }
    Collections.sort(evenList, (num1, num2) -> num2 - num1);
    Collections.sort(oddList, (num1, num2) -> num2 - num1);
    int[] evenSum = new int[cnt + 1], oddSum = new int[cnt + 1]; // [0, i - 1] 范围内
    for (int i = 1; i < evenSum.length; i++) {
      if (i - 1 < evenList.size()) {
        evenSum[i] = evenSum[i - 1] + evenList.get(i - 1);
      } else {
        evenSum[i] = -1;
      }
      if (i - 1 < oddList.size()) {
        oddSum[i] = oddSum[i - 1] + oddList.get(i - 1);
      } else {
        oddSum[i] = -1;
      }
    }
    int result = 0;
    for (int i = 0; i <= cnt; i += 2) {
      // i 个 odd, cnt - i 个 even
      if (evenSum[cnt - i] != -1 && oddSum[i] != -1) {
        result = Math.max(result, evenSum[cnt - i] + oddSum[i]);
      }
    }
    return result;
  }

}