package question0975_odd_even_jump;

import java.util.LinkedList;

/**
 * 动态规划。
 *
 * 单调栈求解下一步的位置。
 *
 * 时间复杂度是 O(n * logn)，其中 n 为数组 A 的长度。空间复杂度是 O(n)。
 *
 * 执行用时：53ms，击败93.51%。消耗内存：42.5MB，击败100.00%。
 */
public class Solution1 {
    private int[][] memo;

    private int[][] next;

    public int oddEvenJumps(int[] A) {
        int n = A.length;
        memo = new int[n][2];
        next = new int[2][n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        sort(A, indexes, 0, n - 1, true);
        next[0] = calculateNext(A, indexes, new LinkedList<>());
        sort(A, indexes, 0, n - 1, false);
        next[1] = calculateNext(A, indexes, new LinkedList<>());
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (oddEvenJumps(A, i, 0)) {
                result++;
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

    private boolean oddEvenJumps(int[] A, int index, int status) {
        if (index == A.length - 1) {
            return true;
        }
        if (memo[index][status] == 1) {
            return true;
        } else if (memo[index][status] == 2) {
            return false;
        }
        int nextIndex = next[status][index];
        if (status == 0) {
            if (nextIndex != -1) {
                if (oddEvenJumps(A, nextIndex, 1)) {
                    memo[index][status] = 1;
                    return true;
                } else {
                    memo[index][status] = 2;
                    return false;
                }
            }
        } else {
            if (nextIndex != -1) {
                if (oddEvenJumps(A, nextIndex, 0)) {
                    memo[index][status] = 1;
                    return true;
                } else {
                    memo[index][status] = 2;
                    return false;
                }
            }
        }
        memo[index][status] = 2;
        return false;
    }
}