package question2125;

public class Solution {

  public int numberOfBeams(String[] bank) {
    int m = bank.length;
    int n = bank[0].length();
    int[] count = new int[m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (bank[i].charAt(j) == '1') {
          count[i]++;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < m; ) {
      while (i < m && count[i] == 0) {
        i++;
      }
      int j = i + 1;
      while (j < m && count[j] == 0) {
        j++;
      }
      if (i < m && j < m) {
        result += count[i] * count[j];
      }
      i = j;
    }
    return result;
  }

}