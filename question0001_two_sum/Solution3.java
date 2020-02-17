package question0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 时间复杂度是O(n)，其中n是nums数组的长度。空间复杂度是O(m)，其中m为nums数组中不同元素的数量。
 *
 * 执行用时：3ms，击败98.75%。消耗内存：37MB，击败92.85%。
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        int n;
        if (null == nums || (n = nums.length) < 2) {    //如果输入的数组为null或者数组中的元素个数少于2个，直接返回null
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();    //map中的键为nums[i]，值为i
        for (int i = 0; i < n; i++) {
            int anotherNum = target - nums[i];  //根据nums[i]的值寻找另一个元素anotherNum
            if (map.containsKey(anotherNum)) {
                return new int[] {map.get(anotherNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;    //没有找到，直接返回null
    }
}