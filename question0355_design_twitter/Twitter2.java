package question0355_design_twitter;

import java.util.*;

/**
 * 为每个用户各设置一个推文链表。
 *
 * 执行用时：30ms，击败85.62%。消耗内存：45.1MB，击败45.04%。
 */
public class Twitter2 {
    private Map<Integer, Set<Integer>> followeeMap; //键：用户ID；值：该用户关注的人的ID集合

    private Map<Integer, List<Integer>> userTweetMap;   //建：用户ID；值：该用户发表的推文链表

    private Map<Integer, Integer> tweetToIndex; //键：推文ID；值：推文编号

    private int index;  //推文编号，从0开始

    /** Initialize your data structure here. */
    public Twitter2() {
        followeeMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        tweetToIndex = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userTweetMap.containsKey(userId)) {
            userTweetMap.put(userId, new ArrayList<>());
        }
        userTweetMap.get(userId).add(0, tweetId);
        tweetToIndex.put(tweetId, index++);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        List<Integer> userList = new ArrayList<>();
        Set<Integer> followees = followeeMap.get(userId);
        if (null != followees) {
            userList.addAll(followees);
            if (!followees.contains(userId)) {
                userList.add(userId);
            }
        } else {
            userList.add(userId);
        }
        int[] curs = new int[userList.size()]; //有多少个用户，就有多少个推文链表，也就需要多少个指针
        while (result.size() < 10) {
            int maxIndex = -1, max = Integer.MIN_VALUE;
            for (int i = 0; i < userList.size(); i++) {
                List<Integer> tweets = userTweetMap.get(userList.get(i));
                if (null != tweets && curs[i] < tweets.size() && max < tweetToIndex.get(tweets.get(curs[i]))) {
                    maxIndex = i;
                    max = tweetToIndex.get(tweets.get(curs[i]));
                }
            }
            if (maxIndex == -1) {
                break;
            }
            result.add(userTweetMap.get(userList.get(maxIndex)).get(curs[maxIndex]++));
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}