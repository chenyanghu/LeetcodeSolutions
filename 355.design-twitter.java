/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 *
 * https://leetcode.com/problems/design-twitter/description/
 *
 * 
 */
class Twitter {
    // To add newest post to the head of the queue
    Deque<Integer[]> posts;
    // Relation between user and its followers
    Map<Integer, Set<Integer>> relation;

    /** Initialize your data structure here. */
    public Twitter() {
        posts = new ArrayDeque<>();
        relation = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        posts.addFirst(new Integer[] { userId, tweetId });
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees;
        if (relation.containsKey(userId))
            followees = relation.get(userId);
        else
            followees = new HashSet<>();
        Iterator<Integer[]> iterator = posts.iterator();
        List<Integer> news = new ArrayList<>();
        while (iterator.hasNext()) {
            if (news.size() == 10)
                break;
            Integer[] post = iterator.next();
            if (post[0] == userId || followees.contains(post[0]))
                news.add(post[1]);
        }
        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees;
        if (relation.containsKey(followerId))
            followees = relation.get(followerId);
        else
            followees = new HashSet<>();
        followees.add(followeeId);
        relation.put(followerId, followees);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees;
        if (relation.containsKey(followerId))
            followees = relation.get(followerId);
        else
            followees = new HashSet<>();
        followees.remove(followeeId);
        relation.put(followerId, followees);
    }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
