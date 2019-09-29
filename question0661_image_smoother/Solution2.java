package question0661_image_smoother;

/**
 * 利用位运算原地修改。
 *
 * （1）由于给定矩阵中的整数范围为 [0, 255]。因此可以用8个bit位来存储像素原始值
 * （2）由于周围的矩阵个数最多为8，因此可以用4个bit位来存储周围点个数
 * （3）由于255 * 8 < 2^12，因此可以用12个bit来存储周围点的加和
 *  以上一共可以用到24个bit，int类型完全满足需求。
 *
 * 时间复杂度是O(m * n)，其中m为矩阵M的行数，n为矩阵M的列数。空间复杂度是O(1)。
 *
 * 执行用时：16ms，击败48.16%。消耗内存：53.7MB，击败68.93%。
 */
public class Solution2 {
    public int[][] imageSmoother(int[][] M) {
        int m;
        if (null == M || (m = M.length) == 0) {
            return null;
        }
        int n;
        if (null == M[0] || (n = M[0].length) == 0) {
            return null;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int MASK = 255;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    int newI = i + directions[k][0], newJ = j + directions[k][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        M[i][j] += (M[newI][newJ] & MASK) << 12;    //假设最低位编号是0，最高位编号是31，则12位及以上存储和的信息
                        M[i][j] += 1 << 8;  //8-11位存储数量信息
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = ((M[i][j] >> 8) & 15) + 1;  //提取出数量信息
                M[i][j] = ((M[i][j] & MASK) + (M[i][j] >> 12)) / count; //提取出和信息
            }
        }
        return M;
    }
}
