package question0244;

/**
 * 采用和question243的Solution2同样的思路。
 *
 * 每次调用shortest()函数的时间复杂度都是O(n)，其中n是words数组的长度。
 *
 * 在LeetCode中提交会超时。
 */
public class WordDistance1 {
    private String[] dictionary;

    private int n;

    public WordDistance1(String[] words) {
        n = words.length;
        dictionary = new String[n];
        for (int i = 0; i < n; i++) {
            dictionary[i] = words[i];
        }
    }
    
    public int shortest(String word1, String word2) {
        int index1 = -1, index2 = -1, result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (word1.equals(dictionary[i])) {
                index1 = i;
                if (index2 >= 0) {
                    result = Math.min(result, index1 - index2);
                }
            } else if (word2.equals(dictionary[i])) {
                index2 = i;
                if (index1 >= 0) {
                    result = Math.min(result, index2 - index1);
                }
            }
        }
        return result;
    }
}