package question0264_ugly_number_ii;

/**
 * 用一个数组记录第1到第n个偶数。需要三个标记位flag2、flag3和flag5来标记数组中的某个索引，初始时flag2、flag3和flag5均指向索引0。
 *
 * flag2          flag3          flag5                 丑数列表
 *                                                     1
 *   0（2）          0（3）         0（5）               1 2
 *   1（4）          0（3）         0（5）               1 2 3
 *   1（4）          1（6）         0（5）               1 2 3 4
 *   2（6）          1（6）         0（5）               1 2 3 4 5
 *   2（6）          1（6）         1（10）              1 2 3 4 5 6
 *   3（8）          2（9）         1（10）              1 2 3 4 5 6 8
 *   ……             ……             ……                  ……
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：7ms，击败95.61%。消耗内存：34.3MB，击败33.33%。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        uglies[0] = 1;
        int flag2 = 0, flag3 = 0, flag5 = 0;
        for (int i = 1; i < n; i++) {
            int tmp2 = uglies[flag2] << 1, tmp3 = uglies[flag3] * 3, tmp5 = uglies[flag5] * 5;
            int min = Math.min(tmp2, Math.min(tmp3, tmp5));
            if (min == tmp2) {
                uglies[i] = min;
                flag2++;
            }
            if (min == tmp3) {
                uglies[i] = min;
                flag3++;
            }
            if (min == tmp5) {
                uglies[i] = min;
                flag5++;
            }
        }
        return uglies[n - 1];
    }
}