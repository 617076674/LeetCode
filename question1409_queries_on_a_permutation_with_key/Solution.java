package question1409_queries_on_a_permutation_with_key;

public class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length], P = new int[m];
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
}