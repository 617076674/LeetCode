package question1033_moving_stones_until_consecutive;

import java.util.Arrays;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：1ms，击败99.65%。消耗内存：34MB，击败100.00%。
 */
public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] result = new int[2];
        int[] array = {a, b, c};
        Arrays.sort(array);
        //两数相差大于1，就直接挪到中间数旁边，需要一次；两数挨着，就不动
        result[0] = (array[1] - array[0] == 1 ? 0 : 1) + (array[2] - array[1] == 1 ? 0 : 1);
        //两数相差等于2，就直接把另一个数挪中间
        result[0] = (array[1] - array[0] == 2 || array[2] - array[1] == 2) ? 1 : result[0];
        //最大值就是两边距离
        result[1] = array[2] - array[0] - 2;
        return result;
    }
}
