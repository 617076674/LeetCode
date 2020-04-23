package lcci0508_draw_line;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] result = new int[length];
        int index = (w / 32) * y + x1 / 32;
        if (length <= index) {
            return result;
        }
        int firstLeft = x1 / 32 * 32, firstRight = firstLeft + 31;
        if (x2 <= firstRight) {
            int num = 0;
            for (int i = x1 - firstLeft; i <= x2 - firstLeft; i++) {
                num |= (1 << (31 - i));
            }
            result[index++] = num;
            if (index == result.length) {
                return result;
            }
        } else {
            int num = 0;
            for (int i = x1 - firstLeft; i < 32; i++) {
                num |= (1 << (31 - i));
            }
            result[index++] = num;
            if (index == result.length) {
                return result;
            }
            for (int i = x1 / 32 + 1; i < x2 / 32; i++) {
                result[index++] = -1;
                if (index == result.length) {
                    return result;
                }
            }
            num = 0;
            for (int i = 0; i <= x2 % 32; i++) {
                num |= (1 << (31 - i));
            }
            result[index++] = num;
            if (index == result.length) {
                return result;
            }
        }
        return result;
    }
}