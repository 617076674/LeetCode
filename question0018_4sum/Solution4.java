package question0018_4sum;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/4sum/
 *
 * 这个思路的时间复杂度分析挺复杂的。首先，排序过程的时间复杂度一定是O(nlogn)，其中n为nums数组的长度。
 * 而形成哈希表的时间复杂度是O(n ^ 2)级别的。而遍历哈希表形成结果的过程的时间复杂度不好算，这和每两个数的和对应的List的大小有关。
 * 而空间复杂度还是很明了的，我们存储了一个哈希表，而哈希表的键存的是两个数的和，这两个数的组合可能产生的和是O(n ^ 2)级别的，
 * 因此空间复杂度是O(n ^ 2)级别的。
 *
 * 执行用时：116ms，击败12.43%。消耗内存：65MB，击败6.17%。
 */
public class Solution4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> listSet = new HashSet<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = nums[i] + nums[j];
                int[] pair = {i, j};    //保证了pair数组里i < j
                if (map.containsKey(num)) {
                    map.get(num).add(pair);
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(pair);
                    map.put(num, list);
                }
            }
        }
        // 寻找组合
        for (int num : map.keySet()) {
            if (map.containsKey(target - num)) {
                List<int[]> list1 = map.get(num);
                List<int[]> list2 = map.get(target - num);
                for (int[] pair1 : list1) {
                    int index1 = pair1[0], index2 = pair1[1];
                    for (int[] pair2 : list2) {
                        int index3 = pair2[0], index4 = pair2[1];
                        if (index2 < index3) {  //防重复
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[index1]);
                            list.add(nums[index2]);
                            list.add(nums[index3]);
                            list.add(nums[index4]);
                            listSet.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(listSet);
    }
}