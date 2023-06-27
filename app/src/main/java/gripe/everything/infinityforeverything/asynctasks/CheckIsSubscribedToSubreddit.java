package gripe.everything.infinityforeverything.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.account.Account;
import gripe.everything.infinityforeverything.subscribedsubreddit.SubscribedSubredditData;

public class CheckIsSubscribedToSubreddit {

    public static void checkIsSubscribedToSubreddit(Executor executor, Handler handler, RedditDataRoomDatabase redditDataRoomDatabase,
                                                    String subredditName, String accountName,
                                                    CheckIsSubscribedToSubredditListener checkIsSubscribedToSubredditListener) {
        executor.execute(() -> {
            if (accountName == null) {
                if (!redditDataRoomDatabase.accountDao().isAnonymousAccountInserted()) {
                    redditDataRoomDatabase.accountDao().insert(Account.getAnonymousAccount());
                }
            }
            SubscribedSubredditData subscribedSubredditData = redditDataRoomDatabase.subscribedSubredditDao().getSubscribedSubreddit(subredditName, accountName == null ? "-" : accountName);
            handler.post(() -> {
                if (subscribedSubredditData != null) {
                    checkIsSubscribedToSubredditListener.isSubscribed();
                } else {
                    checkIsSubscribedToSubredditListener.isNotSubscribed();
                }
            });
        });
    }

    public interface CheckIsSubscribedToSubredditListener {
        void isSubscribed();

        void isNotSubscribed();
    }
}
