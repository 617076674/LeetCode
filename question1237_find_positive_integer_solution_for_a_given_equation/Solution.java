package question1237_find_positive_integer_solution_for_a_given_equation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 执行用时：1ms，击败100.00%。消耗内存：37.4MB，击败5.55%。
 */
public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; customfunction.f(i, 1) <= z; i++) {
            for (int j = 1; customfunction.f(i, j) <= z; j++) {
                if (customfunction.f(i, j) == z) {
                    result.add(Arrays.asList(i, j));
                    break;
                }
            }
        }
        return result;
    }
}