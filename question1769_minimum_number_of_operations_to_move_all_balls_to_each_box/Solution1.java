package question1769_minimum_number_of_operations_to_move_all_balls_to_each_box;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                list.add(i);
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int index : list) {
                result[i] += Math.abs(index - i);
            }
        }
        return result;
    }

}