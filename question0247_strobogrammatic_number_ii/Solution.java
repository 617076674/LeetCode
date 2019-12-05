package question0247_strobogrammatic_number_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是O(5 ^ n)。空间复杂度是O(n)。
 *
 * 执行用时：3ms，击败99.43%。消耗内存：50.3MB，击败100.00%。
 */
public class Solution {
    private List<String> list = new ArrayList<>();

    private char[] num; //用以存储当前数字的字符数组

    private char[] selfPair = {'0', '1', '8'};  //自己和自己中心对称的数

    private char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};  //中心对称的两个数

    public List<String> findStrobogrammatic(int n) {
        num = new char[n];
        findStrobogrammatic(0, n - 1);
        return list;
    }

    private void findStrobogrammatic(int left, int right) {
        if (left == right) {
            for (int i = 0; i < selfPair.length; i++) {
                num[left] = selfPair[i];
                list.add(String.valueOf(num));
            }
            return;
        }
        if (left > right) {
            list.add(String.valueOf(num));
            return;
        }
        int i = 0;
        if (left == 0) {
            i++;
        }
        for (; i < pairs.length; i++) {
            num[left] = pairs[i][0];
            num[right] = pairs[i][1];
            findStrobogrammatic(left + 1, right - 1);
        }
    }
}