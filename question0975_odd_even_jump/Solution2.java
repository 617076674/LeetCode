package question0975_odd_even_jump;

import java.util.LinkedList;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0] 表示第一次跳跃是奇数次跳跃时能否到达数组末尾。
 * dp[i][1] 表示第一次跳跃是偶数次跳跃时能否到达数组末尾。
 *
 * 初始化条件：
 * dp[A.length - 1][0] = dp[A.length - 1][1] = true。
 *
 * 状态转移方程：
 * 当 next[0][i] != -1 时，dp[i][0] = dp[next[0][i]][1]。
 * 当 next[1][i] != -1 时，dp[i][1] = dp[next[1][i]][0]。
 *
 * 时间复杂度是 O(n * logn)，其中 n 为数组 A 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：40ms，击败98.70%。消耗内存：41.7MB，击败100.00%。
 */
public class Solution2 {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        int[][] next = new int[2][n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        sort(A, indexes, 0, n - 1, true);
        next[0] = calculateNext(A, indexes, new LinkedList<>());
        sort(A, indexes, 0, n - 1, false);
        next[1] = calculateNext(A, indexes, new LinkedList<>());
        int result = 1;
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = dp[n - 1][1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (next[0][i] != -1) {
                dp[i][0] = dp[next[0][i]][1];
                if (dp[i][0]) {
                    result++;
                }
            }
            if (next[1][i] != -1) {
                dp[i][1] = dp[next[1][i]][0];
            }
        }
        return result;
    }

    private void sort(int[] A, int[] arr, int left, int right, boolean natural) {
        if (left >= right) {
            return;
        }
        swap(arr, left, (int) (Math.random() * (right - left) + left + 1));
        int lessThan = left, i = left + 1, greaterThan = right + 1;
        while (i < greaterThan) {
            if ((natural ? A[arr[i]] < A[arr[left]] : A[arr[i]] > A[arr[left]])
                    || (A[arr[i]] == A[arr[left]] && arr[i] < arr[left])) {
                lessThan++;
                swap(arr, lessThan, i);
                i++;
            } else {
                greaterThan--;
                swap(arr, greaterThan, i);
            }

        }
        swap(arr, left, lessThan);
        lessThan--;
        sort(A, arr, left, lessThan, natural);
        sort(A, arr, greaterThan, right, natural);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int[] calculateNext(int[] A, int[] indexes, LinkedList<Integer> stack) {
        int[] result = new int[A.length];
        stack.push(indexes[0]);
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() < indexes[i]) {
                result[stack.pop()] = indexes[i];
            }
            stack.push(indexes[i]);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}