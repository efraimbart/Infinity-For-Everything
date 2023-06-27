package gripe.everything.infinityforeverything.events;

import java.util.ArrayList;

import gripe.everything.infinityforeverything.SortType;
import gripe.everything.infinityforeverything.post.Post;
import gripe.everything.infinityforeverything.postfilter.PostFilter;

public class ProvidePostListToViewPostDetailActivityEvent {
    public long postFragmentId;
    public ArrayList<Post> posts;
    public int postType;
    public String subredditName;
    public String username;
    public String userWhere;
    public String multiPath;
    public String query;
    public String trendingSource;
    public PostFilter postFilter;
    public SortType sortType;
    public ArrayList<String> readPostList;

    public ProvidePostListToViewPostDetailActivityEvent(long postFragmentId, ArrayList<Post> posts, int postType,
                                                        String subredditName, String username, String userWhere,
                                                        String multiPath, String query, String trendingSource,
                                                        PostFilter postFilter, SortType sortType, ArrayList<String> readPostList) {
        this.postFragmentId = postFragmentId;
        this.posts = posts;
        this.postType = postType;
        this.subredditName = subredditName;
        this.username = username;
        this.userWhere = userWhere;
        this.multiPath = multiPath;
        this.query = query;
        this.trendingSource = trendingSource;
        this.postFilter = postFilter;
        this.sortType = sortType;
        this.readPostList = readPostList;
    }
}
