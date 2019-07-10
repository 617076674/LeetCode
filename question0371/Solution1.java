package question0371;

/**
 * @author qianyihui
 * @date 2019-07-10
 *
 * 利用位运算。
 */
public class Solution1 {
    public int getSum(int a, int b) {
        int flag = 0, result = 0;
        for (int i = 0; i < 32; i++) {
            if (((a >> i) & 1) == 1) {
                if (((b >> i) & 1) == 1) {
                    // a为1，b为1，flag为1
                    if (flag == 1) {
                        result |= (1 << i);
                        // a为1，b为1，flag为0
                    } else {
                        flag = 1;
                    }
                } else {
                    // a为1，b为0，flag为1，什么都不变
                    // a为1，b为0，flag为0
                    if (flag == 0) {
                        result |= (1 << i);
                    }
                }
            } else {
                if (((b >> i) & 1) == 1) {
                    // a为0，b为1，flag为1，什么都不变
                    // a为0，b为1，flag为0
                    if (flag == 0) {
                        result |= (1 << i);
                    }
                } else {
                    // a为0，b为0，flag为0，什么都不变
                    // a为0，b为0，flag为1
                    if (flag == 1) {
                        result |= (1 << i);
                        flag = 0;
                    }
                }
            }
        }
        return result;
    }
}
