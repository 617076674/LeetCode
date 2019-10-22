package question0941_valid_mountain_array;

/**
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败89.41%。消耗内存：39MB，击败92.20%。
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        int n;
        if (null == A || (n = A.length) < 3) {
            return false;
        }
        if (A[1] <= A[0]) {  //没有上升沿
            return false;
        }
        int status = 1; //status=1表示正在寻找上升沿，status=2表示正在寻找下降沿
        for (int i = 1; i < n; i++) {
            if (status == 1) {
                if (A[i] < A[i - 1]) {
                    status++;
                } else if (A[i] == A[i - 1]) {
                    return false;
                }
            } else if (status == 2) {
                if (A[i] >= A[i - 1]) {
                    return false;
                }
            }
        }
        return status == 2; //没有下降沿也需要返回false
    }
}
