package question0157_read_n_characters_given_read4;

/**
 * https://leetcode-cn.com/problems/read-n-characters-given-read4/
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.23%。消耗内存：34.6MB，击败100.00%。
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int times = n >> 2, result = 0, backN = n;
        if (n % 4 != 0) {
            times++;

        }
        for (int i = 0; i < times; i++) {
            char[] tmp = new char[4];
            int count = read4(tmp);
            result += count;
            for (int j = 0; j < count; j++) {
                buf[(i << 2) + j] = tmp[j];
                n--;
                if (n == 0) {
                    return backN;
                }
            }
        }
        return result;
    }
}