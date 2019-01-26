package question190;

import java.util.HashMap;

public class Solution3 {
    private HashMap<Byte, Integer> hashMap = new HashMap<>();
    public int reverseBits(int n) {
        Byte[] bytes = new Byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >> (8 * i)) & 0xFF);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]);
            if(i != 3){
                result <<= 8;
            }
        }
        return result;
    }
    private int reverseByte(byte n){
        Integer result = hashMap.get(n);
        if(null != result){
            return result;
        }
        result = 0;
        for (int i = 0; i < 8; i++) {
            result += (n >> i) & 1;
            if(i != 7){
                result <<= 1;
            }
        }
        hashMap.put(n, result);
        return result;
    }
}
