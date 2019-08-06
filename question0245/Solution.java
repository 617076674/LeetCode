package question0245;

/**
 * @author qianyihui
 * @date 2019-08-06
 *
 * 在question0243的基础上对word1和word2相同的情况做一个特殊处理。
 *
 * 时间复杂度是O(n)，其中n为words数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败92.50%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int pre = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (pre >= 0) {
                        result = Math.min(result, i - pre);
                    }
                    pre = i;
                }
            }
            return result;
        }
        int index1 = -1, index2 = -1;
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
