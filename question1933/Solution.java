package question1933;

public class Solution {

    public boolean isDecomposable(String s) {
      boolean has2 = false;
      for (int i = 0; i < s.length(); i++) {
        int j = i;
        while (j + 1< s.length() && s.charAt(j + 1) == s.charAt(i)) {
          j++;
        }
        // [i, j]
        int cnt = j - i + 1;
        if (cnt % 3 == 1) {
          return false;
        }
        if (cnt % 3 == 2) {
          if (has2) {
            return false;
          }
          has2 = true;
        }
        i = j;
      }
      return has2;
    }

}