package question2040;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    List<Integer> positiveList1 = new ArrayList<>(), negativeList1 = new ArrayList<>(),
        positiveList2 = new ArrayList<>(), negativeList2 = new ArrayList<>();
    for (int num1 : nums1) {
      if (num1 < 0) {
        negativeList1.add(num1);
      } else {
        positiveList1.add(num1);
      }
    }
    for (int num2 : nums2) {
      if (num2 < 0) {
        negativeList2.add(num2);
      } else {
        positiveList2.add(num2);
      }
    }
    long left = -100000000000L, right = 100000000000L;
    while (left < right) {
      long mid = left + ((right - left) >> 1);
      long curCnt = 0;
      for (int i = 0, j = positiveList2.size() - 1; i < positiveList1.size(); i++) {
        while (j >= 0 && 1L * positiveList1.get(i) * positiveList2.get(j) > mid) {
          j--;
        }
        curCnt += j + 1;
      }
      for (int i = 0, j = 0; i < negativeList1.size(); i++) {
        while (j < positiveList2.size() && 1L * negativeList1.get(i) * positiveList2.get(j) > mid) {
          j++;
        }
        curCnt += positiveList2.size() - j;
      }
      for (int i = 0, j = 0; i < positiveList1.size(); i++) {
        while (j < negativeList2.size() && 1L * positiveList1.get(i) * negativeList2.get(j) <= mid) {
          j++;
        }
        curCnt += j;
      }
      for (int i = 0, j = negativeList2.size() - 1; i < negativeList1.size(); i++) {
        while (j >= 0 && 1L * negativeList1.get(i) * negativeList2.get(j) <= mid) {
          j--;
        }
        curCnt += negativeList2.size() - 1 - j;
      }
      if (curCnt < k) {
        left = mid + 1L;
      } else {
        right = mid;
      }
    }
    return left;
  }

}