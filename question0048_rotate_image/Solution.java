package question0048_rotate_image;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * 以示例2所给矩阵中(0, 0)位置为例，如果旋转，有如下规律：
 *
 * (3, 0) -> (0, 0)
 * (3, 3) -> (3, 0)
 * (0, 3) -> (0, 0)
 * (0, 0) -> (0, 3)
 *
 * 同理，对于(0, 1)位置，有如下旋转规律：
 *
 * (2, 0) -> (0, 1)
 * (3, 2) -> (2, 0)
 * (1, 3) -> (3, 2)
 * (0, 1) -> (1, 3)
 *
 * 同理，对于(0, 2)位置，有如下旋转规律：
 *
 * (1, 0) -> (0, 2)
 * (3, 1) -> (1, 0)
 * (2, 3) -> (3, 1)
 * (0, 2) -> (2, 3)
 *
 * 对于(0, 3)位置，我们已经在处理(0, 0)位置的旋转中涉及了该值，我们不该再继续旋转。
 *
 * 按照这个规律，我们从最外层一直旋转到最内层，直至不能旋转为止。对于n阶矩阵，我们需要旋转的层数是n/2。
 *
 * 时间复杂度是O(n ^ 2)，其中n为矩阵的行数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.1MB，击败59.40%。
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int k = 0; k <= n / 2; k++) {
            for (int i = k; i < n - 1 - k; i++) {
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[n - 1 - i][k];
                matrix[n - 1 - i][k] = matrix[n - 1 - k][n - 1 - i];
                matrix[n - 1 - k][n - 1 - i] = matrix[i][n - 1 - k];
                matrix[i][n - 1 - k] = tmp;
            }
        }
    }
}