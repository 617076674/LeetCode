package question018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177660
 */
public class Solution4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> listSet = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, List<Integer[]>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = nums[i] + nums[j];
                Integer[] pair = {i, j};
                if (hashMap.containsKey(num)) {
                    hashMap.get(num).add(pair);
                } else {
                    List<Integer[]> list = new ArrayList<>();
                    list.add(pair);
                    hashMap.put(num, list);
                }
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.containsKey(target - integer)) {
                List<Integer[]> list1 = hashMap.get(integer);
                List<Integer[]> list2 = hashMap.get(target - integer);
                for (Integer[] pair1 : list1) {
                    int index1 = pair1[0];
                    int index2 = pair1[1];
                    for (Integer[] pair2 : list2) {
                        int index3 = pair2[0];
                        int index4 = pair2[1];
                        if (index2 < index3) {
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
