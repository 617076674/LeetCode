package question1375_bulb_switcher_iii;

/**
 * 假设灯的编号从0开始至n - 1，对于第i个操作，点亮编号为light[i] - 1的灯，去看前i个操作点亮的灯的编号的最大值，如果该值等于i，
 * 说明前i展灯全被点亮了。
 *
 * 时间复杂度是O(n)，其中n为light数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：51.4MB，击败100.00%。
 */
public class Solution2 {
    public int numTimesAllBlue(int[] light) {
        int result = 0, right = 0;
        for (int i = 0; i < light.length; i++) {
            right = Math.max(right, light[i] - 1);
            if (right == i) {
                result++;
            }
        }
        return result;
    }
}