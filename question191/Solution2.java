package question191;

import java.util.HashMap;

public class Solution2 {
    private HashMap<Byte, Integer> hashMap = new HashMap<>();
    public int hammingWeight(int n) {
        Byte[] bytes = new Byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >> i * 8) & 0xFF);
            System.out.println(bytes[i]);
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += countOne(bytes[i]);
        }
        return count;
    }
    private int countOne(byte n){
        Integer value = hashMap.get(n);
        if(null != value){
            return value;
        }
        value = 0;
        for(int i = 0; i < 8; i++){
            if(1 == ((n >> i) & 1)){
                value++;
            }
        }
        hashMap.put(n, value);
        return value;
    }
}
