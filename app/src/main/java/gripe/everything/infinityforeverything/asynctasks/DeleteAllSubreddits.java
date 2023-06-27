package gripe.everything.infinityforeverything.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;

public class DeleteAllSubreddits {

    public static void deleteAllSubreddits(Executor executor, Handler handler, RedditDataRoomDatabase redditDataRoomDatabase,
                                           DeleteAllSubredditsAsyncTaskListener deleteAllSubredditsAsyncTaskListener) {
        executor.execute(() -> {
            redditDataRoomDatabase.subredditDao().deleteAllSubreddits();
            handler.post(deleteAllSubredditsAsyncTaskListener::success);
        });
    }

    public interface DeleteAllSubredditsAsyncTaskListener {
        void success();
    }
}
