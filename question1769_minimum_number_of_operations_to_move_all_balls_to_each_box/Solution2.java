package question1769_minimum_number_of_operations_to_move_all_balls_to_each_box;

public class Solution2 {

  public int[] minOperations(String boxes) {
    int[] result = new int[boxes.length()];
    int left = 0, right = 0, total = 0;//左边盒子的个数，右边盒子的个数，操作数
    //计算第一个盒子的操作数
    if (boxes.charAt(0) == '1') {
      left++;
    }
    for (int i = 1; i < boxes.length(); i++) {
      if (boxes.charAt(i) == '1') {
        right++;
        total += i;
      }
    }
    result[0] = total;
    //根据前一个盒子的操作数，计算下一个盒子的操作数
    for (int i = 1; i < boxes.length(); i++) {
      total = total + left - right;
      if (boxes.charAt(i) == '1') {
        left++;
        right--;
      }
      result[i] = total;
    }
    return result;
  }

}
