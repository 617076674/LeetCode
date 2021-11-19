package question1963_minimum_number_of_swaps_to_make_the_string_balanced;

public class Solution {

  public int minSwaps(String s) {
    int result = 0, left = 0, right = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        left++;
      } else {
        right++;
      }
      if (right > left) {
        result++;
        right--;
        left++;
      }
    }
    return result;
  }

}