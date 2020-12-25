package lcof56_ii_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu;

public class Solution {

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int count = 0;
      for (int num : nums) {
        if (((num >> i) & 1) == 1) {
          count++;
        }
      }
      if (count % 3 == 1) {
        result |= (1 << i);
      }
    }
    return result;
  }

}