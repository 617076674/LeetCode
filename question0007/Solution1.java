package question0007;

/**
 * 利用异常来处理溢出的情况。
 * <p>
 * 时间复杂度是O(x)。空间复杂度是O(1)。
 * <p>
 * 执行用时：9ms，击败49.97%。消耗内存：34.2MB，击败78.22%。
 */
public class Solution1 {
    public int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        if (x < 0) {
            x = -x;
            stringBuilder.append("-");
        }
        while (x > 0) {
            stringBuilder.append(x % 10);
            x /= 10;
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
