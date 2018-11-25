package question120;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list = new ArrayList<>();
        list.add(triangle.get(0).get(0));

        List<Integer> lastList = generateNextSum(list, 1, triangle);
        int minIndex = 0;
        for (int i = 0; i < lastList.size(); i++) {
            if(lastList.get(i) < lastList.get(minIndex)) {
                minIndex = i;
            }
        }
        return lastList.get(minIndex);
    }

    /*
     * 生成第n层的和，list中记录着第n - 1层的和
     */
    private List<Integer> generateNextSum(List<Integer> list, int n, List<List<Integer>> triangle) {
        if(n == triangle.size()) {
            return list;
        }
        List<Integer> retList = new ArrayList<>();
        for (int j = 0; j < triangle.get(n).size(); j++) {
            if(j == 0) {
                retList.add(list.get(0) + triangle.get(n).get(0));
            }
            if(j > 0 && j < triangle.get(n).size() - 1) {
                retList.add(Math.min(list.get(j - 1), list.get(j)) + triangle.get(n).get(j));
            }
            if(j == triangle.get(n).size() - 1) {
                retList.add(list.get(list.size() - 1) + triangle.get(n).get(triangle.get(n).size() - 1));
            }
        }
        return generateNextSum(retList, n + 1, triangle);
    }
}
