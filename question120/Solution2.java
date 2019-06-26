package question120;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list1 = triangle.get(0);
        if (triangle.size() == 1) {
            int minIndex = 0;
            for (int i = 1; i < list1.size(); i++) {
                if (list1.get(i) < list1.get(minIndex)) {
                    minIndex = i;
                }
            }
            return list1.get(minIndex);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < triangle.size() - 1; i++) {
            list2.clear();
            list2.add(list1.get(0) + triangle.get(i + 1).get(0));
            for (int j = 1; j < triangle.get(i + 1).size() - 1; j++) {
                list2.add(Math.min(list1.get(j - 1), list1.get(j)) + triangle.get(i + 1).get(j));
            }
            list2.add(list1.get(list1.size() - 1) + triangle.get(i + 1).get(triangle.get(i + 1).size() - 1));
            list1.clear();
            list1.addAll(list2);
        }
        int minIndex = 0;
        for (int i = 1; i < list2.size(); i++) {
            if (list2.get(i) < list2.get(minIndex)) {
                minIndex = i;
            }
        }
        return list2.get(minIndex);
    }
}
