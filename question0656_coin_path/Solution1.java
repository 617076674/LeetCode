package question0656_coin_path;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private long[] memo;

    private int[] next;

    public List<Integer> cheapestJump(int[] A, int B) {
        memo = new long[A.length];
        next = new int[A.length];
        jump(A, B, 0);
        List<Integer> result = new ArrayList<>();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i]) {
            result.add(i + 1);
        }
        if (i == A.length - 1 && A[i] >= 0) {
            result.add(A.length);
            return result;
        }
        return new ArrayList<>();
    }

    /**
     * 现在所在的位置是 i，求从该位置跳到末尾的最小花费，next[i] 表示当前位置的下一步
     */
    public long jump(int[] A, int B, int i) {
        if (i == A.length - 1 && A[i] >= 0) {
            return A[i];
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        long result = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + B && j < A.length; j++) {
            if (A[j] != -1) {
                long cost = A[i] + jump(A, B, j);
                if (cost < result) {
                    result = cost;
                    next[i] = j;
                }
            }
        }
        memo[i] = result;
        return result;
    }
}