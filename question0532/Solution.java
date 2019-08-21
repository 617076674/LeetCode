package question0532;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-21
 *
 * 哈希表。
 *
 * 执行用时：24ms，击败76.22%。消耗内存：48.9MB，击败38.99%。
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        int n;
        if (null == nums || (n = nums.length) < 2 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();    //用哈希表保存数组nums中每个数字及其出现的次数
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int result = 0;
        for (Integer tmp : map.keySet()) {
            if (k == 0) {
                if (map.get(tmp) >= 2) {    //如果k == 0，那么需要存在两个相同的tmp才行
                    result++;
                }
            } else {
                if (map.containsKey(k + tmp)) {
                    result++;
                }
            }
        }
        return result;
    }
}