package contest.question5;

public class Solution {
    public int numSteps(String s) {
        int step = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length() - 1) == '0') {
                s = divideTwo(s);
            } else {
                s = addOne(s);
            }
            step++;
        }
        return step;
    }

    private String divideTwo(String s) {
        return s.substring(0, s.length() - 1);
    }

    private String addOne(String s) {
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = flag + s.charAt(i) - '0';
            if (num >= 2) {
                num -= 2;
                flag = 1;
            } else {
                flag = 0;
            }
            sb.append(num);
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}