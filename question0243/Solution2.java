package question0243;

/**
 * @author qianyihui
 * @date 2019-08-04
 *
 * 从头到尾遍历words数组，用index1保存最近一次出现word1的索引，用index2保存最近一次出现word2的索引。
 *
 * 每当遇到word1或word2时，就需要更新index1或index2，以及最短距离。
 *
 * 时间复杂度是O(n)，其中n为words数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败85.71%。消耗内存：39.5MB，击败100.00%。
 */
public class Solution2 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 >= 0) {
                    result = Math.min(result, index1 - index2);
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 >= 0) {
                    result = Math.min(result, index2 - index1);
                }
            }
        }
        return result;
    }
}
