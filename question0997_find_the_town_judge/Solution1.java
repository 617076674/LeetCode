package question0997_find_the_town_judge;

/**
 * 暴力破解法。
 *
 * 时间复杂度和空间复杂度均是O(N ^ 2)。
 *
 * 执行用时：9ms，击败27.83%。消耗内存：69.9MB，击败5.20%。
 */
public class Solution1 {
    public int findJudge(int N, int[][] trust) {
        boolean[][] graph = new boolean[N + 1][N + 1];  //graph[i][j]表示第i个人信任第j个人
        for (int[] edge : trust) {
            graph[edge[0]][edge[1]] = true;
        }
        int result = -1;
        for (int i = 1; i <= N; i++) {
            boolean isJudge = true; //判断第i个人是否是小镇的法官
            for (int j = 1; j <= N; j++) {
                if (i != j && graph[i][j]) {
                    isJudge = false;
                    break;
                }
            }
            if (isJudge) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && !graph[j][i]) {
                        isJudge = false;
                        break;
                    }
                }
            }
            if (isJudge) {
                if (result != -1) {
                    return -1;
                }
                result = i;
            }
        }
        return result;
    }
}