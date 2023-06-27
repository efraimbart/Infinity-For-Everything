package gripe.everything.infinityforeverything.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;

public class DeleteMultiredditInDatabase {

    public static void deleteMultiredditInDatabase(Executor executor, Handler handler,
                                                   RedditDataRoomDatabase redditDataRoomDatabase,
                                                   String accountName, String multipath,
                                                   DeleteMultiredditInDatabaseListener deleteMultiredditInDatabaseListener) {
        executor.execute(() -> {
            if (accountName.equals("-")) {
                redditDataRoomDatabase.multiRedditDao().anonymousDeleteMultiReddit(multipath);
            } else {
                redditDataRoomDatabase.multiRedditDao().deleteMultiReddit(multipath, accountName);
            }
            handler.post(deleteMultiredditInDatabaseListener::success);
        });
    }
    public interface DeleteMultiredditInDatabaseListener {
        void success();
    }
}
