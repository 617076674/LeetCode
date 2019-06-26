package question077;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82929815
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> listList;

    public List<List<Integer>> combine(int n, int k) {
        listList = new ArrayList<>();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        combine(new ArrayList<>(), array, k);
        return listList;
    }

    private void combine(List<Integer> list, int[] array, int k) {
        if (list.size() == k) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i]) || (!list.isEmpty() && list.get(list.size() - 1) < array[i])) {
                continue;
            }
            list.add(array[i]);
            combine(list, array, k);
            list.remove(list.size() - 1);
        }
    }
}
