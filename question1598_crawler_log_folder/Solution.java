package question1598_crawler_log_folder;

public class Solution {

    public int minOperations(String[] logs) {
        int distance = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                distance = Math.max(distance - 1, 0);
            } else if (!"./".equals(log)) {
                distance++;
            }
        }
        return distance;
    }

}