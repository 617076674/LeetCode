package question1629_slowest_key;

public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        long[] time = new long[26];
        for (int i = 0; i < keysPressed.length(); i++) {
            char c = keysPressed.charAt(i);
            if (i == 0) {
                time[c - 'a'] += releaseTimes[0];
            } else {
                time[c - 'a'] = Math.max(time[c - 'a'], releaseTimes[i] - releaseTimes[i - 1]);
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < 26; i++) {
            if (time[i] >= time[maxIndex]) {
                maxIndex = i;
            }
        }
        return (char) ('a' + maxIndex);
    }

}