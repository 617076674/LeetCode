package question0496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 单调栈。
 *
 * 时间复杂度是O(n1 * n2)，其中n1是nums1数组的长度，n2是nums2数组的长度。空间复杂度是O(n2)。
 *
 * 执行用时：7ms，击败83.46%。消耗内存：37.9MB，击败52.34%。
 */
public class Solution2 {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
        map.put(nums2[stack.pop()], nums2[i]);
      }
      stack.push(i);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
  }

}
