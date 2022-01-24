package question2151;

public class Solution {

  public int maximumGood(int[][] statements) {
    int result = 0;
    int n = statements.length;
    for (int status = 0; status <= (1 << n) - 1; status++) {
      // status 第 i 位是 1 表明第 i 个是好人，否则是坏人
      boolean flag = true;
      for (int i = 0; i < n && flag; i++) {
        if ((status & (1 << i)) == 0) {
          // i 是坏人，坏人说的话均跳过
          continue;
        }
        // i 是好人，好人说的话必须是真的
        for (int j = 0; j < n; j++) {
          if (statements[i][j] == 2) {
            continue;
          } else if (statements[i][j] == 0) {
            // i 认为 j 是坏人
            if ((status & (1 << j)) != 0) {
              flag = false;
              break;
            }
          } else {
            if ((status & (1 << j)) == 0) {
              flag = false;
              break;
            }
          }
        }
      }
      if (flag) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
          if ((status & (1 << i)) != 0) {
            temp++;
          }
        }
        result = Math.max(result, temp);
      }
    }
    return result;
  }

}