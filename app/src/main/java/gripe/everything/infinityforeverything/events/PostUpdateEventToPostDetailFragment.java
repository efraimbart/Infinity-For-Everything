package gripe.everything.infinityforeverything.events;

import gripe.everything.infinityforeverything.post.Post;

public class PostUpdateEventToPostDetailFragment {
    public final Post post;

    public PostUpdateEventToPostDetailFragment(Post post) {
        this.post = post;
    }
}
