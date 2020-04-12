package question1271_hexspeak;

/**
 * 执行用时：2ms，击败99.09%。消耗内存：38.1MB，击败14.29%。
 */
public class Solution {
    public String toHexspeak(String num) {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        long number = Long.parseLong(num);
        if (number == 0) {
            sb.append('O');
        } else {
            while (number > 0) {
                int index = (int) (number % 16);
                if (index == 0) {
                    sb.append('O');
                } else if (index == 1) {
                    sb.append('I');
                } else if (index < 10){
                    return "ERROR";
                } else {
                    sb.append(chars[index]);
                }
                number /= 16;
            }
        }
        return sb.reverse().toString();
    }
}