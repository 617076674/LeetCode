package question204;

public class Solution2 {
    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int result = 0;
        for(int i = 2; i < n; i++){
            if(!flag[i]){
                result++;
                for (int j = 2; j * i < n; j++) {
                    flag[i * j] = true;
                }
            }
        }
        return result;
    }
}
