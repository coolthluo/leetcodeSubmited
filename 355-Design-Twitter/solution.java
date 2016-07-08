public class Twitter {
    private static int timeStamp = 0;
    private Map<Integer, User> userMap;
    
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            next = null;
        }
    }
    
    //OO design so User can follow, unfollow and post itself
    public class User {
        public int id;
        public Set<Integer> followedSet;
        public Tweet tweet_head;
        
        public User(int id) {
            this.id = id;
            followedSet = new HashSet<>();
            follow(id);
            tweet_head = null;
        }
        
        public void follow(int id) {
            followedSet.add(id);
        }
        
        public void unfollow(int id) {
            followedSet.remove(id);
        }
        
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with 
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this 
    // heap before we get the 10 most recent tweet.
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> userSet = userMap.get(userId).followedSet;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(userSet.size(), (t1, t2) -> t2.time - t1.time);
        for (int user : userSet) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) {
                pq.offer(t);
            }
        }
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        return res;
    }
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */