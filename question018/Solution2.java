package question018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177660
 */
public class Solution2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        if (target % 4 == 0 && hashMap.containsKey(target / 4) && hashMap.get(target / 4) >= 4) {
            addToListList(target / 4, target / 4, target / 4, target / 4, listList);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            arrayList.add(integer);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i) * 3 + arrayList.get(j) == target && hashMap.get(arrayList.get(i)) >= 3) {
                    addToListList(arrayList.get(i), arrayList.get(i), arrayList.get(i), arrayList.get(j), listList);
                }
                if (arrayList.get(i) + arrayList.get(j) * 3 == target && hashMap.get(arrayList.get(j)) >= 3) {
                    addToListList(arrayList.get(i), arrayList.get(j), arrayList.get(j), arrayList.get(j), listList);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i) * 2 + arrayList.get(j) * 2 == target && hashMap.get(arrayList.get(i)) >= 2 && hashMap.get(arrayList.get(j)) >= 2) {
                    addToListList(arrayList.get(i), arrayList.get(i), arrayList.get(j), arrayList.get(j), listList);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                for (int k = j + 1; k < arrayList.size(); k++) {
                    if (arrayList.get(i) * 2 + arrayList.get(j) + arrayList.get(k) == target && hashMap.get(arrayList.get(i)) >= 2) {
                        addToListList(arrayList.get(i), arrayList.get(i), arrayList.get(j), arrayList.get(k), listList);
                    }
                    if (arrayList.get(i) + arrayList.get(j) * 2 + arrayList.get(k) == target && hashMap.get(arrayList.get(j)) >= 2) {
                        addToListList(arrayList.get(i), arrayList.get(j), arrayList.get(j), arrayList.get(k), listList);
                    }
                    if (arrayList.get(i) + arrayList.get(j) + arrayList.get(k) * 2 == target && hashMap.get(arrayList.get(k)) >= 2) {
                        addToListList(arrayList.get(i), arrayList.get(j), arrayList.get(k), arrayList.get(k), listList);
                    }
                    int num = target - arrayList.get(i) - arrayList.get(j) - arrayList.get(k);
                    if (num > arrayList.get(k) && hashMap.containsKey(num)) {
                        addToListList(arrayList.get(i), arrayList.get(j), arrayList.get(k), num, listList);
                    }
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, int num4, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        listList.add(list);
    }
}
