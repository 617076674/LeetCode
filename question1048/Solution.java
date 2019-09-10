package question1048;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深度优先遍历。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为words数组的长度。
 *
 * 执行用时：125ms，击败45.36%。消耗内存：52.2MB，击败100.00%。
 */
public class Solution {
    private boolean[][] graph;  //图，graph[i][j] = true表示words数组中索引为i的单词可以到达索引为j的单词

    private Map<String, Integer> stringToInt = new HashMap<>(); //key为words数组中的单词，value为该单词在words数组中的索引

    private int result; //记录结果，即最长字符串链

    private int n;  //记录words数组的长度

    private int[] intToLen; //intToLen[i]记录以words数组中第i个单词为起点的最长字符串链

    public int longestStrChain(String[] words) {
        //对输入为空，或输入的words数组长度为0的情况做特殊处理
        if (words == null || (n = words.length) == 0) {
            return 0;
        }
        //根据长度对words数组中的单词进行分组
        List<String>[] lists = new ArrayList[16];
        for (int i = 0; i < 16; i++) {
            lists[i] = new ArrayList<>();
        }
        int index = 0;
        for (String string : words) {
            lists[string.length() - 1].add(string);
            stringToInt.put(string, index++);
        }
        graph = new boolean[n][n];
        for (int i = 1; i < 16; i++) {
            List<String> list1 = lists[i - 1], list2 = lists[i];
            for (String s1 : list1) {
                for (String s2 : list2) {
                    if (hasPath(s1, s2)) {
                        int index1 = stringToInt.get(s1), index2 = stringToInt.get(s2);
                        graph[index1][index2] = true;
                    }
                }
            }
        }
        intToLen = new int[n];
        for (int i = 0; i < n; i++) {
            //只有words数组中以索引i开头的最长字符串链长度没有被计算过时，才进行dfs遍历
            if (intToLen[i] == 0) {
                dfs(i, 1);
            }
        }
        return result;
    }

    private void dfs(int now, int len) {
        intToLen[now] = len;
        result = Math.max(result, len);
        for (int i = 0; i < n; i++) {
            if (graph[now][i]) {
                dfs(i, len + 1);
            }
        }
    }

    /**
     * 判断字符串s1是否能够到达字符串s2。
     */
    private boolean hasPath(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (flag) {
                if (count[i] != 0) {
                    return false;
                }
            } else {
                if (count[i] == -1) {
                    flag = true;
                } else if (count[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
