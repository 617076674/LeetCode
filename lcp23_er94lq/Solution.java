package lcp23_er94lq;

public class Solution {

  public boolean isMagic(int[] target) {
    int[] origin = new int[target.length];
    for (int i = 0; i < origin.length; i++) {
      origin[i] = i + 1;
    }
    int index1 = 0, index2 = 0, k = 0;
    while (true) {
      step1(origin, index1);
      int begin = index1;
      for (; index2 < target.length; index2++) {
        if (k != 0 && index2 - begin >= k) {
          break;
        }
        if (target[index1] != origin[index2]) {
          if (k == 0) {
            k = index2 - begin;
          }
          break;
        }
        index1++;
      }
      if (index1 == origin.length) {
        return true;
      }
      if (k == 0 || k != index2 - begin) {
        return false;
      }
    }
  }

  // 将 nums 数组中 [index, nums.length - 1] 范围内的元素进行第一步操作
  private void step1(int[] nums, int index) {
    int[] copy = new int[nums.length - index];
    for (int i = 0; i < copy.length; i++) {
      copy[i] = nums[i + index];
    }
    int j = 0;
    for (int i = 1; i < copy.length; i += 2) {
      nums[index + j++] = copy[i];
    }
    for (int i = 0; i < copy.length; i += 2) {
      nums[index + j++] = copy[i];
    }
  }

}