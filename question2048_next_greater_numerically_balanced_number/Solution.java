package question2048_next_greater_numerically_balanced_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  private List<Integer> balanceNumbers = new ArrayList<>();

  private List<int[]> countList = new ArrayList<>();

  public int nextBeautifulNumber(int n) {
    for (int i = 1; i <= 7; i++) {
      dfs(i, 0, new ArrayList<>(), 1);
    }
    for (int[] count : countList) {
      int bits = 0;
      for (int value : count) {
        bits += value;
      }
      dfs(count, 0, bits, 0);
    }
    Collections.sort(balanceNumbers);
    for (int balanceNumber : balanceNumbers) {
      if (balanceNumber > n) {
        return balanceNumber;
      }
    }
    return -1;
  }

  private void dfs(int bits, int countBits, List<Integer> list, int index) {
    if (countBits == bits) {
      int[] count = new int[8];
      for (Integer integer : list) {
        count[integer] = integer;
      }
      countList.add(count);
      return;
    }
    if (countBits > bits) {
      return;
    }
    if (index >= 8) {
      return;
    }
    dfs(bits, countBits, list, index + 1);
    list.add(index);
    dfs(bits, countBits + index, list, index + 1);
    list.remove(list.size() - 1);
  }

  private void dfs(int[] count, int num, int bits, int countBits) {
    if (countBits == bits) {
      balanceNumbers.add(num);
      return;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        count[i]--;
        dfs(count, num * 10 + i, bits, countBits + 1);
        count[i]++;
      }
    }
  }

}