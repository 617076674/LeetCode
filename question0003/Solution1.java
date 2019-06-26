package question0003;

/**
 * 暴力破解法。
 * <p>
 * 时间复杂度是O(n ^ 3)，其中n为字符串s的长度。空间复杂度是O(1)。
 * <p>
 * 执行用时：96ms，击败23.81%。消耗内存：35.9MB，击败99.43%。
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int result = 1;
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                flag = false;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    result = Math.max(result, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
