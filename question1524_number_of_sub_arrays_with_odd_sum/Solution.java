package question1524_number_of_sub_arrays_with_odd_sum;

public class Solution {

  public int numOfSubarrays(int[] arr) {
    int odd = 0, even = 1, result = 0, sum = 0;
    for (int num : arr) {
      sum += num;
      if ((sum & 1) == 0) {
        result += odd;
        even++;
      } else {
        result += even;
        odd++;
      }
      result %= 1000000007;
    }
    return result;
  }

}