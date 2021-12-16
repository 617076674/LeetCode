package contest_12_11.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public int[] maxSubsequence(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(id -> nums[id]));
    for (int i = 0; i < nums.length; i++) {
      pq.add(i);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<Integer> list = new ArrayList<>(pq);
    Collections.sort(list);
    int[] result = new int[k];
    for (int i = 0; i < list.size(); i++) {
      result[i] = nums[list.get(i)];
    }
    return result;
  }


  public static void main(String[] args) {
    int[] nums = {3,4,3,3};
    int k = 2;
    System.out.println(Arrays.toString(new Solution().maxSubsequence(nums, k)));
  }

}