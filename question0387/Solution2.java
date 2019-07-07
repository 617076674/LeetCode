package question0387;

/**
 * @author qianyihui
 * @date 2019-07-07
 *
 * 哈希表。
 *
 * 时间复杂度是O(n)，其中n是字符串s的长度。空间复杂度是O(1)。
 *
 * 执行用时：17ms，击败78.54%。消耗内存：48.3MB，击败36.72%。
 */
public class Solution2 {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
