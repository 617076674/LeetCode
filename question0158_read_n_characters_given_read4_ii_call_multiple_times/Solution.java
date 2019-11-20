package question0158_read_n_characters_given_read4_ii_call_multiple_times;

/**
 * https://leetcode-cn.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * <p>
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 * <p>
 * 执行用时：1ms，击败99.23%。消耗内存：34.6MB，击败100.00%。
 */
public class Solution extends Reader4 {
    private char[] previous;

    private int index;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
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

    private void printPrevious() {
        System.out.println("index = " + index);
        for (int i = 0; i < previous.length; i++) {
            System.out.print(previous[i] + " ");
        }
        System.out.println();
    }
}