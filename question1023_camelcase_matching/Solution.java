package question1023_camelcase_matching;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(judge(query, pattern));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        System.out.println(new Solution().camelMatch(queries, pattern));
    }

    private static boolean judge(String query, String pattern) {
        int index1 = 0, index2 = 0;
        while (index1 < query.length() || index2 < pattern.length()) {
            if (index1 >= query.length()) {
                return false;
            }
            if (index2 >= pattern.length()) {
                char c = query.charAt(index1);
                if (c < 'a' || c > 'z') {
                    return false;
                }
                index1++;
            } else {
                char c1 = query.charAt(index1), c2 = pattern.charAt(index2);
                if (c1 == c2) {
                    index1++;
                    index2++;
                } else if (c1 < 'a' || c1 > 'z') {
                    return false;
                } else {
                    index1++;
                }
            }
        }
        return true;
    }

}