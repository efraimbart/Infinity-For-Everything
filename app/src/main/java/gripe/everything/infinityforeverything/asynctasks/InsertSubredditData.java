package gripe.everything.infinityforeverything.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.subreddit.SubredditData;

public class InsertSubredditData {

    public static void insertSubredditData(Executor executor, Handler handler, RedditDataRoomDatabase db,
                                           SubredditData subredditData,
                                           InsertSubredditDataAsyncTaskListener insertSubredditDataAsyncTaskListener) {
        executor.execute(() -> {
            db.subredditDao().insert(subredditData);
            handler.post(insertSubredditDataAsyncTaskListener::insertSuccess);
        });
    }

    public interface InsertSubredditDataAsyncTaskListener {
        void insertSuccess();
    }
}
