package question0471_encode_string_with_shortest_length;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 最重要的一个问题：如果判断一个字符串是否可以由其中某一子串重复多次构成？如何找出该子串是什么？
 *
 * 对于字符串s，在(s + s)的索引1处开始寻找s的位置，如果寻找到的位置index < n，说明s可由其[0, index)内的子串重复多次构成。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为字符串s的长度。
 *
 * 执行用时：189ms，击败5.80%。消耗内存：43.3MB，击败40.00%。
 */
public class Solution1 {
    private Map<String, String> memo = new HashMap<>();

    public String encode(String s) {
        int n;
        if (null == s || (n = s.length()) < 5) {
            return s;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int index = (s + s).indexOf(s, 1);
        String result = s;
        for (int i = 1; i < n; i++) {
            String left = encode(s.substring(0, i)), right = encode(s.substring(i, n));
            if ((left + right).length() < result.length()) {
                result = left + right;
            }
        }
        if (index < n) {
            int repeateTimes = n / index;
            if ((repeateTimes + "[" + s.substring(0, index) + "]").length() < result.length()) {
                result = repeateTimes + "[" + encode(s.substring(0, index)) + "]";
            }
        }
        memo.put(s, result);
        return result;
    }
}