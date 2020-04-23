package lcci0502_bianry_number_to_string;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.6MB，击败100.00%。
 */
public class Solution {
    public String printBin(double num) {
        if (num < 0 || num > 1) {
            return "ERROR";
        }
        if (Double.compare(num, 1) == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("0.");
        double tmp = 0.5;
        while (true) {
            if (num >= tmp) {
                sb.append(1);
                num -= tmp;
            } else {
                sb.append(0);
            }
            tmp /= 2;
            if (Double.compare(num, 0) == 0) {
                return sb.toString();
            }
            if (sb.length() > 32) {
                return "ERROR";
            }
        }
    }
}