package question0427_construct_quad_tree;

/**
 * 递归构建。
 *
 * 时间复杂度是O((log(N)) * (N ^ 2))。空间复杂度是O(logN)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：41.1MB，击败92.86%。
 */
public class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    private Node construct(int[][] grid, int top, int bottom, int left, int right) {
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] != grid[top][left]) {
                    Node node = new Node(false, false);
                    int mid1 = top + ((bottom - top) >> 1), mid2 = left + ((right - left) >> 1);
                    node.topLeft = construct(grid, top, mid1, left, mid2);
                    node.topRight = construct(grid, top, mid1, mid2 + 1, right);
                    node.bottomLeft = construct(grid, mid1 + 1, bottom, left, mid2);
                    node.bottomRight = construct(grid, mid1 + 1, bottom, mid2 + 1, right);
                    return node;
                }
            }
        }
        return new Node(grid[top][left] == 1, true);
    }
}