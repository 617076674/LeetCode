package question087;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83035336
 */

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public boolean isScramble(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        boolean[][][] flag = new boolean[n1][n1][n1 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                flag[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= n1; len++) {
            for (int i = 0; i < n1 - len + 1; i++) {
                for (int j = 0; j < n1 - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        if (flag[i][j][len]) {
                            continue;
                        }
                        if ((flag[i][j][k] && flag[i + k][j + k][len - k]) || (flag[i][j + len - k][k] && flag[i + k][j][len - k])) {
                            flag[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return flag[0][0][n1];
    }
}
