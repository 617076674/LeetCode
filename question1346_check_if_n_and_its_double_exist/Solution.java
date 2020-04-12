package question1346_check_if_n_and_its_double_exist;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为数组arr的长度。
 *
 * 执行用时：2ms，击败96.46%。消耗内存：39.2MB，击败100.00%。
 */
public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || ((num & 1) == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}