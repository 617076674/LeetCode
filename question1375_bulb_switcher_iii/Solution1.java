package question1375_bulb_switcher_iii;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n为light数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：755ms，击败100.00%。消耗内存：50.9MB，击败100.00%。
 */
public class Solution1 {
    public int numTimesAllBlue(int[] light) {
        int n = light.length, result = 0;
        boolean[] isOpen = new boolean[n];
        for (int i = 0; i < n; i++) {
            isOpen[light[i] - 1] = true;
            boolean flag = true;
            for (int j = 0; j <= i; j++) {
                if (!isOpen[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }
}