package question0997_find_the_town_judge;

/**
 * 法官是入度为N-1，出度为0的节点。
 *
 * 时间复杂度和空间复杂度均是O(N)。
 *
 * 执行用时：4ms，击败48.11%。消耗内存：60.2MB，击败22.58%。
 */
public class Solution2 {
    public int findJudge(int N, int[][] trust) {
        int[] outDegrees = new int[N + 1], inDegrees = new int[N + 1];
        for (int[] edge : trust) {
            outDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }
        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (outDegrees[i] == 0 && inDegrees[i] == N - 1) {
                if (result != -1) {
                    return -1;
                }
                result = i;
            }
        }
        return result;
    }
}