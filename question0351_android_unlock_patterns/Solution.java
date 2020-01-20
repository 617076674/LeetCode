package question0351_android_unlock_patterns;

import java.util.Arrays;

/**
 * 回溯法。
 *
 * 时间复杂度是O(n!)。空间复杂度是O(n)。
 *
 * 执行用时：35ms，击败70.37%。消耗内存：33.1MB，击败100.00%。
 */
public class Solution {
    private boolean used[] = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int result = 0;
        for (int len = m; len <= n; len++) {
            result += calcPatterns(-1, len);
            Arrays.fill(used, false);
        }
        return result;
    }

    private boolean isValid(int last, int index) {
        if (used[index]) {  //如果该点已经被使用了，显然不能再重复经过
            return false;
        }
        if (last == -1) {   //如果该点是第一个点，显然是合法的
            return true;
        }
        //1-如果index和last位于同一行或同一列上的相邻两点，显然是合法的
        //2-如果index和last的位置是国际象棋中的马步，显然是合法的
        if (((index + last) & 1) == 1) {
            return true;
        }
        int mid = (index + last) >> 1;
        //可能是0-8,1-7,2-6,3-5，此时看4处的点是否被访问过
        if (mid == 4) {
            return used[4];
        }
        //不是同一行也不是同一列上的点，也不是马步，显然是合法的
        if ((index % 3 != last % 3) && (index / 3 != last / 3)) {
            return true;
        }
        //对于同一行或同一列上的点，如0-2,2-8，看中间点mid是否被访问过
        return used[mid];
    }

    private int calcPatterns(int last, int len) {
        if (len == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(last, i)) {
                used[i] = true;
                result += calcPatterns(i, len - 1);
                used[i] = false;
            }
        }
        return result;
    }
}