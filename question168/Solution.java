package question168;

import java.util.HashMap;

public class Solution {
    public String convertToTitle(int n) {
        HashMap<Integer, Character> hashMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hashMap.put(i, (char) ('A' + i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n-- >= 0) {
            stringBuilder.append(hashMap.get(n % 26));
            n /= 26;
            if (0 == n) {
                break;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
