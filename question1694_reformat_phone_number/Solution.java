package question1694_reformat_phone_number;

public class Solution {
    
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
                sb.append(number.charAt(i));
            }
        }
        return generate(sb, 0);
    }
    
    private String generate(StringBuilder sb, int index) {
        if (index >= sb.length()) {
            return "";
        }
        if (sb.length() - index == 2) {
            return sb.substring(index);
        } else if (sb.length() - index == 3) {
            return sb.substring(index);
        } else if (sb.length() - index == 4) {
            return sb.substring(index, index + 2) + "-" + sb.substring(index + 2);
        }
        return sb.substring(index, index + 3) + "-" + generate(sb, index + 3);
    }
    
}