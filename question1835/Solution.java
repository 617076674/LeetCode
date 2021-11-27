package question1835;

public class Solution {

  public int getXORSum(int[] arr1, int[] arr2) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      long a = 0, b = 0, c = 0, d = 0;
      for (int num1 : arr1) {
        if ((num1 & (1 << i)) == 0) {
          a++;
        } else {
          b++;
        }
      }
      for (int num2 : arr2) {
        if ((num2 & (1 << i)) == 0) {
          c++;
        } else {
          d++;
        }
      }
      long count0 = a * c + a * d + b * c, count1 = b * d;
      count0 %= 2;
      count1 %= 2;
      if ((count0 == 1 && count1 == 1) || (count0 == 0 && count1 == 1)) {
        result ^= (1 << i);
      }
    }
    return result;
  }

}