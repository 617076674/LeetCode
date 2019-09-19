package question0443;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为chars数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败34.96%。消耗内存：40MB，击败40.00%。
 */
public class Solution {
    public int compress(char[] chars) {
        int n;
        if (null == chars || (n = chars.length) == 0) {
            return 0;
        }
        int result = 0, index1 = 0, index2 = 0;
        while (index1 < n) {
            int i = index1;
            while (i + 1 < n && chars[i + 1] == chars[index1]) {
                i++;
            }
            int count = i - index1 + 1;
            chars[index2++] = chars[index1];
            result++;
            if (count > 1) {
                for (char c : ("" + count).toCharArray()) {
                    chars[index2++] = c;
                }
                result += ("" + count).length();
            }
            index1 = i + 1;
        }
        return result;
    }
}
