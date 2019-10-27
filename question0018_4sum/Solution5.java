package question0018_4sum;

import java.util.*;

/**
 * 时间复杂度是O(n ^ 4)，其中n是nums数组的长度。空间复杂度是O(n ^ 2)。
 *
 * 执行用时：98ms，击败19.51%。消耗内存：53.5MB，击败11.70%。
 */
public class Solution5 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> listSet = new HashSet<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = nums[i] + nums[j];
                int[] pair = {i, j};
                if (map.containsKey(num)) {
                    map.get(num).add(pair);
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(pair);
                    map.put(num, list);
                }
            }
        }
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int tmp = target - nums[i] - nums[j];
                if (!map.containsKey(tmp)) {
                    continue;
                }
                List<int[]> list = map.get(tmp);
                for (int[] array : list) {
                    if (array[0] > j) {
                        List<Integer> retList = new ArrayList<>();
                        retList.add(nums[i]);
                        retList.add(nums[j]);
                        retList.add(nums[array[0]]);
                        retList.add(nums[array[1]]);
                        listSet.add(retList);
                    }
                }
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        for (List<Integer> list : listSet) {
            listList.add(list);
        }
        return listList;
    }
}