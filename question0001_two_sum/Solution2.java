package question0001_two_sum;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-3chong-jie-fa-by-617076674/
 *
 * 用哈希表记录nums[i]元素对应的索引。
 *
 * 注意，nums数组中可能有重复元素，即可能有相同的nums[i]对应不同的索引的情况，因此用哈希表的值对应的是一个List。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度均是O(m)，其中m为nums数组中不同元素的数量。
 *
 * 执行用时：16ms，击败58.84%。消耗内存：40.2MB，击败33.23%。
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        Arrays.sort(nums);  //排序，为双指针查找做准备
        int left = 0, right = n - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                int[] result = new int[2];
                result[0] = map.get(nums[left]).get(0);
                //如果两个数相等，显然不能取同一个索引，需要取对应list中的第二个索引
                if (nums[left] == nums[right]) {
                    result[1] = map.get(nums[right]).get(1);
                } else {
                    result[1] = map.get(nums[right]).get(0);
                }
                return result;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}