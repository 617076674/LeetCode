package question0119_pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        List<Integer> nextList = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            nextList.clear();
            nextList.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                nextList.add(list.get(j) + list.get(j + 1));
            }
            nextList.add(1);
            list = new ArrayList<>(nextList);
        }
        return list;
    }

}
