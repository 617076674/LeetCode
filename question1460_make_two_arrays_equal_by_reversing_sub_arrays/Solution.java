package question1460_make_two_arrays_equal_by_reversing_sub_arrays;

/**
 * 哈希表。
 *
 * 时间复杂度是 O(n)，其中 n 为 target 数组的长度。空间复杂度是 O(1001)。
 *
 * 执行用时：2ms，击败87.60%。消耗内存：39.6MB，击败100.00%。
 */
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        for (int num : target) {
            map[num]++;
        }
        for (int num : arr) {
            map[num]--;
            if (map[num] < 0) {
                return false;
            }
        }
        for (int num : map) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}