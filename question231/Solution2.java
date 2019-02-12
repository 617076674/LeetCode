package question231;

public class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        return count == 1;
    }
}
