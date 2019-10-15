package question1089_duplicate_zeros;

/**
 * 先统计到哪些字符能够显示，再从后往前填充数组。
 *
 * 时间复杂度是O(n)，其中n为arr数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.88%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        int index = 0, n = arr.length, i = 0;
        for (; i < n; i++) {
            if (arr[i] == 0) {
                index += 2;
            } else {
                index++;
            }
            if (index >= n) {
                break;
            }
        }
        int j = n - 1;
        if (index > n) {
            arr[j--] = 0;
            i--;
        }
        for (; j >= 0; j--) {
            if (arr[i] == 0) {
                arr[j--] = 0;
                if (j < 0) {
                    break;
                }
                arr[j] = 0;
                i--;
            } else {
                arr[j] = arr[i--];
            }
        }
    }
}
