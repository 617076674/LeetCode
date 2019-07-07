package question0387;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：78ms，击败31.79%。消耗内存：49.3MB，击败30.95%。
 */
public class Solution1 {
    public int firstUniqChar(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
