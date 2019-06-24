package question0905;

/**
 * @author qianyihui
 * @date 2019-06-24
 *
 * 快速排序算法的应用。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败97.44%。消耗内存：43.8MB，击败77.41%。
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        //[0, i)存放偶数，[j, A.length - 1]存放奇数
        int i = 0, j = A.length;
        while (i < j) {
            if ((A[i] & 1) == 1) {
                j--;
                swap(A, i, j);
            } else {
                i++;
            }
        }
        return A;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
