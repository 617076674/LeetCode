package question0405_convert_a_number_to_hexadecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * 先转为二进制，再转为十进制，注意-2147483648转变为正数会越界，需要单独处理。
 *
 * 时间复杂度是O(log(num))。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败13.62%。消耗内存：34.1MB，击败94.44%。
 */
public class Solution {
    private Map<String, String> map = new HashMap<>();

    {
        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "a");
        map.put("1011", "b");
        map.put("1100", "c");
        map.put("1101", "d");
        map.put("1110", "e");
        map.put("1111", "f");
    }

    public String toHex(int num) {
        if (num == Integer.MIN_VALUE) {
            return "80000000";
        }
        return binaryToHex(toBinary(num));
    }

    private String binaryToHex(String num) {
        StringBuilder sb = new StringBuilder();
        String first = num.substring(0, num.length() % 4);
        int n = first.length();
        if (n > 0) {
            while (first.length() < 4) {
                first = "0" + first;
            }
            sb.append(map.get(first));
        }
        for (int i = n; i < num.length(); i += 4) {
            sb.append(map.get(num.substring(i, i + 4)));
        }
        return sb.toString();
    }

    private String toBinary(int num) {
        if (num >= 0) {
            return positiveToBinary(num);
        } else {
            StringBuilder sb = new StringBuilder(positiveToBinary(-num));
            while (sb.length() < 32) {
                sb.insert(0, '0');
            }
            int index = sb.length() - 1;
            for (; index >= 0; index--) {
                if (sb.charAt(index) == '1') {
                    break;
                }
            }
            for (int i = 0; i < index; i++) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
            }
            return sb.toString();
        }
    }

    private String positiveToBinary(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num >>= 1;
        }
        return sb.reverse().toString();
    }
}
