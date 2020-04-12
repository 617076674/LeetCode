package contest.question2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        int[] P = new int[m];
        for (int i = 1; i <= m; i++) {
            P[i - 1] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < P.length; j++) {
                if (queries[i] == P[j]) {
                    result[i] = j;
                    break;
                }
            }
            int[] tmp = new int[m];
            tmp[0] = P[result[i]];
            int index = 0;
            for (int j = 1; j < m; j++) {
                if (index == result[i]) {
                    index++;
                    j--;
                    continue;
                }
                tmp[j] = P[index++];
            }
            P = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] queries = {4,1,2,2};
        int m = 4;
        System.out.println(Arrays.toString(new Solution().processQueries(queries, m)));
    }
}