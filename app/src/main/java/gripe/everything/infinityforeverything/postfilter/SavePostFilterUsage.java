package gripe.everything.infinityforeverything.postfilter;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;

public class SavePostFilterUsage {
    public static void savePostFilterUsage(RedditDataRoomDatabase redditDataRoomDatabase, Executor executor,
                                           PostFilterUsage postFilterUsage) {
        executor.execute(() -> redditDataRoomDatabase.postFilterUsageDao().insert(postFilterUsage));
    }
}
