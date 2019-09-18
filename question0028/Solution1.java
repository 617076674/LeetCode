package question0028;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n1 * n2)，其中n1为字符串haystack的长度，n2为字符串needle的长度。空间复杂度是O(1)。
 *
 * 执行用时；4ms，击败40.43%。消耗内存：37.2MB，击败61.27%。
 */
public class Solution1 {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2 = needle.length();
        if (n2 == 0) {
            return 0;
        }
        for (int i = 0; i < n1 - n2 + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 1; j < n2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}
