package question1287_element_appearing_more_than_25_in_sorted_array;

/**
 * 时间复杂度是O(n)，其中n为数组arr的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败74.23%。消耗内存：38.9MB，击败100.00%。
 */
public class Solution {
    public int findSpecialInteger(int[] arr) {
        int index = 0, n = arr.length, size = n >> 2;
        while (index < n) {
            int i = index;
            while (i + 1 < n && arr[i + 1] == arr[i]) {
                i++;
            }
            if (i - index + 1 > size) {
                return arr[i];
            }
            index = i + 1;
        }
        return -1;
    }
}