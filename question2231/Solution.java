package question2231;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public int largestInteger(int num) {
    List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n = num;
    while (n > 0) {
      int digit = n % 10;
      if (digit % 2 == 0) {
        list1.add(digit);
      } else {
        list2.add(digit);
      }
      list.add(digit);
      n /= 10;
    }
    Collections.sort(list1);
    Collections.sort(list2);
    Collections.reverse(list);
    int index1 = list1.size() - 1, index2 = list2.size() - 1;
    int res = 0;
    for (int digit : list) {
      if (digit % 2 == 0) {
        res = res * 10 + list1.get(index1);
        index1--;
      } else {
        res = res * 10 + list2.get(index2);
        index2--;
      }
    }
    return res;
  }

}
