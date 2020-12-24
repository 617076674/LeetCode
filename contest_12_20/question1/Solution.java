package contest_12_20.question1;

class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
                sb.append(number.charAt(i));
            }
        }
        return generate(sb, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reformatNumber("1-23-45 6"));
        System.out.println(new Solution().reformatNumber("123 4-567"));
        System.out.println(new Solution().reformatNumber("123 4-5678"));
        System.out.println(new Solution().reformatNumber("12"));
        System.out.println(new Solution().reformatNumber("--17-5 229 35-39475 "));
    }

    // [index, sb.length - 1]
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