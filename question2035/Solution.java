package question2035;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    private long total;

    public int minimumDifference(int[] nums) {
        for (int num : nums) {
            total += num;
        }
        int mid = nums.length / 2;
        dfs1(nums, 0, mid - 1, 0L, 0, 0);
        dfs2(nums, mid, nums.length - 1, 0L, 0, mid);
        Map<Integer, List<Long>> finalMap1 = transform(map1), finalMap2 = transform(map2);
        long result = Long.MAX_VALUE;
        for (Map.Entry<Integer, List<Long>> entry : finalMap1.entrySet()) {
            List<Long> list1 = entry.getValue();
            List<Long> list2 = finalMap2.get(nums.length / 2 - entry.getKey());
            if (null != list2) {
                Long temp = check(list1, list2, total / 2);
                if (null != temp) {
                    result = Math.min(result, Math.abs(temp + temp - total));
                }
            }
        }
        return (int) result;
    }

    // 在 list1 和 list2 中寻找 2 个数，其和小于 target 且最接近 target，返回其和
    private Long check(List<Long> list1, List<Long> list2, long target) {
        int index1 = 0, index2 = list2.size() - 1;
        Long result = null;
        while (index1 < list1.size() && index2 >= 0) {
            long temp = list1.get(index1) + list2.get(index2);
            if (temp == target) {
                return target;
            } else if (temp > target) {
                index2--;
            } else {
                if (null == result) {
                    result = temp;
                } else if (temp > result) {
                    result = temp;
                }
                index1++;
            }
        }
        return result;
    }

    private static Map<Integer, List<Long>> transform(Map<Integer, Set<Long>> map) {
        Map<Integer, List<Long>> result = new HashMap<>();
        for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
            List<Long> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            result.put(entry.getKey(), list);
        }
        return result;
    }

    private Map<Integer, Set<Long>> map1 = new HashMap<>(), map2 = new HashMap<>();

    private void dfs1(int[] nums, int left, int right, long sum, int count, int index) {
        if (index == right + 1) {
            Set<Long> set = map1.get(count);
            if (null == set) {
                set = new HashSet<>();
                set.add(sum);
                map1.put(count, set);
            } else {
                set.add(sum);
            }
            return;
        }
        dfs1(nums, left, right, sum, count, index + 1);
        dfs1(nums, left, right, sum + nums[index], count + 1, index + 1);
    }

    private void dfs2(int[] nums, int left, int right, long sum, int count, int index) {
        if (index == right + 1) {
            Set<Long> set = map2.get(count);
            if (null == set) {
                set = new HashSet<>();
                set.add(sum);
                map2.put(count, set);
            } else {
                set.add(sum);
            }
            return;
        }
        dfs2(nums, left, right, sum, count, index + 1);
        dfs2(nums, left, right, sum + nums[index], count + 1, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        System.out.println(new Solution().minimumDifference(nums));
    }

}