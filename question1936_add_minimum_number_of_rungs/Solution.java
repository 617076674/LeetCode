package question1936_add_minimum_number_of_rungs;

public class Solution {

    public int addRungs(int[] rungs, int dist) {
        int curHeight = 0, result = 0;
        for (int i = 0; i < rungs.length; i++) {
            result += (rungs[i] - curHeight) / dist;
            if (((rungs[i] - curHeight) % dist) == 0) {
                result--;
            }
            curHeight = rungs[i];
        }
        return result;
    }

}