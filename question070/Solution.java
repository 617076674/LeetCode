package question070;

public class Solution {

    public int climbStairs(int n) {
        int[] path = new int[n];
        if(n == 1 || n == 2){
            return n;
        }
        path[0] = 1;
        path[1] = 2;
        for (int i = 2; i < n; i++){
            path[i] = path[i - 1] + path[i - 2];
        }
        return path[n - 1];
    }
}
