package question070;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82862289
 *
 * 用一个数组来保存前面的所有值。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：32.6MB，击败78.62%。
 */
public class Solution2 {

    public int climbStairs(int n) {
        int[] path = new int[n];
        if(n == 1 || n == 2){
            return n;
        }
        path[0] = 1;
        path[1] = 2;
        for (int i = 2; i < n; i++){
            path[i] = path[i - 1] + path[i - 2];
        }
        return path[n - 1];
    }

}
