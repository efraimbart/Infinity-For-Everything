package gripe.everything.infinityforeverything.postfilter;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;

public class DeletePostFilter {
    public static void deletePostFilter(RedditDataRoomDatabase redditDataRoomDatabase, Executor executor, PostFilter postFilter) {
        executor.execute(() -> redditDataRoomDatabase.postFilterDao().deletePostFilter(postFilter));
    }
}
