package question0246;

/**
 * @author qianyihui
 * @date 2019-08-21
 *
 * 执行用时：0ms，击败100.00%。消耗内存：34.1MB，击败100.00%。
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return isStrobogrammatic(num.charAt(0));
        }
        for (int i = 0; i < (n >> 1); i++) {
            if (!isStrobogrammatic(num.charAt(i), num.charAt(n - 1 - i))) {
                return false;
            }
        }
        if ((n & 1) == 1) {
            return isStrobogrammatic(num.charAt(n >> 1));
        }
        return true;
    }

    private boolean isStrobogrammatic(char c1, char c2) {
        switch (c1) {
            case '0': return c2 == '0';
            case '1': return c2 == '1';
            case '6': return c2 == '9';
            case '8': return c2 == '8';
            case '9': return c2 == '6';
            default: return false;
        }
    }

    private boolean isStrobogrammatic(char c) {
        return c == '0' || c == '1' || c == '8';
    }
}
