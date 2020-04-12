package question1394_find_lucky_integer_in_an_array;

/**
 * 时间复杂度是O(n)，其中n为arr数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败66.46%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
}