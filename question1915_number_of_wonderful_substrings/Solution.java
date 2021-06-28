package question1915_number_of_wonderful_substrings;

public class Solution {

  public long wonderfulSubstrings(String word) {
    int status = 0;
    long result = 0;
    int[] statusCount = new int[1024];
    statusCount[0]++;
    for (int i = 0; i < word.length(); i++) {
      status ^= 1 << (word.charAt(i) - 'a');
      for (int j = 0; j < statusCount.length; j++) {
        int temp = j ^ status;
        if ((temp & (temp - 1)) == 0) {
          result += statusCount[j];
        }
      }
      statusCount[status]++;
    }
    return result;
  }

}