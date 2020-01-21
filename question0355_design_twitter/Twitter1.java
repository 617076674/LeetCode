package question0355_design_twitter;

import java.util.*;

/**
 * 扫描所有推特信息，根据推特作者寻找前10条。
 *
 * 执行用时：179ms，击败12.78%。消耗内存：59.8MB，击败5.29%。
 */
public class Twitter1 {
    private Map<Integer, Set<Integer>> followeeMap;

    private Map<Integer, Integer> tweetToUserMap;

    private List<Integer> list;

    /** Initialize your data structure here. */
    public Twitter1() {
        followeeMap = new HashMap<>();
        tweetToUserMap = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetToUserMap.put(tweetId, userId);
        list.add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0 && result.size() < 10; i--) {
            int owner = tweetToUserMap.get(list.get(i));
            if (owner == userId || (followeeMap.containsKey(userId) && followeeMap.get(userId).contains(owner))) {
                result.add(list.get(i));
            }
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