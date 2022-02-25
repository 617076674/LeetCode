package question0717_1_bit_and_2_bit_characters;

public class Solution {

  public boolean isOneBitCharacter(int[] bits) {
    int n;
    if (null == bits || (n = bits.length) == 0) {
      return false;
    }
    int index = 0;
    while (true) {
      if (index == n - 1) {
        return true;
      } else if (index >= n) {
        return false;
      }
      if (bits[index] == 1) {
        index += 2;
      } else {
        index++;
      }
    }
  }

}