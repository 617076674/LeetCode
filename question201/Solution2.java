package question201;

public class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int temp = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            temp <<= 1;
        }
        return m * temp;
    }
}
