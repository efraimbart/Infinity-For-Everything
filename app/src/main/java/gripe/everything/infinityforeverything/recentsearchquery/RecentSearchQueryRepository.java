package gripe.everything.infinityforeverything.recentsearchquery;

import androidx.lifecycle.LiveData;

import java.util.List;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;

public class RecentSearchQueryRepository {
    private LiveData<List<RecentSearchQuery>> mAllRecentSearchQueries;

    RecentSearchQueryRepository(RedditDataRoomDatabase redditDataRoomDatabase, String username) {
        mAllRecentSearchQueries = redditDataRoomDatabase.recentSearchQueryDao().getAllRecentSearchQueriesLiveData(username);
    }

    LiveData<List<RecentSearchQuery>> getAllRecentSearchQueries() {
        return mAllRecentSearchQueries;
    }
}
