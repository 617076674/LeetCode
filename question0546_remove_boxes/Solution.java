package question0546_remove_boxes;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是 O(n ^ 4)，其中 n 为 boxes 数组的长度。空间复杂度是 O(n ^ 3)。
 *
 * 执行用时：26ms，击败77.69%。消耗内存：50.3MB，击败100.00%。
 */
public class Solution {
    private int[][][] memo;

    public int removeBoxes(int[] boxes) {
        memo = new int[boxes.length][boxes.length][boxes.length];
        return removeBoxes(boxes, 0, boxes.length - 1, 0);
    }

    // 对于 [left, right] 范围内的盒子，其中 right 后面连续跟有 k 个和 boxes[right] 相同的数字，能获得的最大积分，
    private int removeBoxes(int[] boxes, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        if (memo[left][right][k] != 0) {
            return memo[left][right][k];
        }
        while (right > left && boxes[right - 1] == boxes[right]) {
            right--;
            k++;
        }
        int result = removeBoxes(boxes, left, right - 1, 0) + (k + 1) * (k + 1);
        for (int i = left; i < right; i++) {
            if (boxes[i] == boxes[right]) {
                result = Math.max(result, removeBoxes(boxes, left, i, k + 1) + removeBoxes(boxes, i + 1, right - 1, 0));
            }
        }
        memo[left][right][k] = result;
        return result;
    }
}