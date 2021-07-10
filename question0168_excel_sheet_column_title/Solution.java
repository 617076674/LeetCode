package question0168_excel_sheet_column_title;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String convertToTitle(int n) {
        Map<Integer, Character> hashMap = new HashMap<>();
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
