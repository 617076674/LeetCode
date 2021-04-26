package question1348_tweet_counts_per_frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetCounts {

  private Map<String, List<Integer>> name2Times = new HashMap<>();

  public TweetCounts() {

  }

  public void recordTweet(String tweetName, int time) {
    List<Integer> list = name2Times.get(tweetName);
    if (null == list) {
      list = new ArrayList<>();
      list.add(time);
      name2Times.put(tweetName, list);
    } else {
      int index = floor(list, time);
      if (index == list.size()) {
        list.add(time);
      } else {
        list.add(index + 1, time);
      }
    }
  }

  private static int ceil(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) == target) {
        left = mid + 1;
      } else if (nums.get(mid) > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (right >= 0 && nums.get(right) == target) {
      return right;
    }
    return left;
  }

  private static int floor(List<Integer> nums, int target) {
    int left = 0, right = nums.size() - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums.get(mid) == target) {
        right = mid - 1;
      } else if (nums.get(mid) > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < nums.size() && nums.get(left) == target) {
      return left;
    }
    return right;
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime,
                                                  int endTime) {
    List<Integer> result = new ArrayList<>();
    List<Integer> list = name2Times.get(tweetName);
    if (null == list) {
      return result;
    }
    int delta;
    switch (freq) {
        case "minute":
            delta = 60;
            break;
        case "hour":
            delta = 3600;
            break;
        default:
            delta = 86400;
    }
    for (int i = 0; ; i++) {
      result.add(floor(list, Math.min(startTime + (i + 1) * delta - 1, endTime))
          - ceil(list,  startTime + i * delta) + 1);
      if (startTime + (i + 1) * delta >= endTime + 1) {
        break;
      }
    }
    return result;
  }

}