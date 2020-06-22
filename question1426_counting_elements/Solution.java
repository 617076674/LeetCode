package question1426_counting_elements;

/**
 * 哈希表。
 *
 * 时间复杂度是 O(n)，其中 n 为数组 arr 的长度。空间复杂度是 O(1002)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37MB，击败100.00%。
 */
public class Solution {
    public int countElements(int[] arr) {
        boolean[] map = new boolean[1002];
        for (int num : arr) {
            map[num] = true;
        }
        int result = 0;
        for (int num : arr) {
            if (map[num + 1]) {
                result++;
            }
        }
        return result;
    }
}