package question0326;

/**
 * @author qianyihui
 * @date 2019-06-25
 * <p>
 * 递归解决。
 * <p>
 * 时间复杂度是O(log(Ingeger.MAX_VALUE))。空间复杂度是O(1)。
 * <p>
 * 执行用时：84ms，击败86.16%。消耗内存：40.5MB，击败13.75%。
 */
public class Solution2 {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n <= 0 || n % 3 != 0) {  //考虑输入n是负数或0的情况
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
