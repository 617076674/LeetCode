package question1238_circular_permutation_in_binary_representation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> circularPermutation(int n, int start) {
        List<String> grayList = generateGray(n);
        List<Integer> list = new ArrayList<>();
        int begin = -1;
        for (int i = 0; i < grayList.size(); i++) {
            int num = Integer.parseInt(grayList.get(i), 2);
            list.add(num);
            if (num == start) {
                begin = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = begin; i < list.size(); i++) {
            result.add(list.get(i));
        }
        for (int i = 0; i < begin; i++) {
            result.add(list.get(i));
        }
        return result;
    }

    private static List<String> generateGray(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> temp = generateGray(n - 1);
        for (String s : temp) {
            result.add("0" + s);
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add("1" + temp.get(i));
        }
        return result;
    }

}