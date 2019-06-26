package question096;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83276409
 */

import java.util.ArrayList;

public class Solution1 {

    public int numTrees(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
        return numTrees(arrayList);
    }

    private int numTrees(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int tempRoot = arrayList.get(i);
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();
            for (int j = 0; j < arrayList.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (arrayList.get(j) < arrayList.get(i)) {
                    less.add(arrayList.get(j));
                } else {
                    greater.add(arrayList.get(j));
                }
            }
            if (less.size() == 0 && greater.size() != 0) {
                count += numTrees(greater);
            } else if (less.size() != 0 && greater.size() == 0) {
                count += numTrees(less);
            } else {
                count += numTrees(less) * numTrees(greater);
            }
        }
        return count;
    }
}
