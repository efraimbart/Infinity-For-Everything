package gripe.everything.infinityforeverything.multireddit;

import android.os.Handler;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.apis.RedditAPI;
import gripe.everything.infinityforeverything.asynctasks.InsertMultireddit;
import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.utils.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FavoriteMultiReddit {
    public interface FavoriteMultiRedditListener {
        void success();
        void failed();
    }

    public static void favoriteMultiReddit(Executor executor, Handler handler, Retrofit oauthRetrofit,
                                           RedditDataRoomDatabase redditDataRoomDatabase,
                                           String accessToken, boolean makeFavorite,
                                           MultiReddit multiReddit, FavoriteMultiRedditListener favoriteMultiRedditListener) {
        Map<String, String> params = new HashMap<>();
        params.put(APIUtils.MULTIPATH_KEY, multiReddit.getPath());
        params.put(APIUtils.MAKE_FAVORITE_KEY, String.valueOf(makeFavorite));
        params.put(APIUtils.API_TYPE_KEY, APIUtils.API_TYPE_JSON);
        oauthRetrofit.create(RedditAPI.class).favoriteMultiReddit(APIUtils.getOAuthHeader(accessToken),
                params).enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    multiReddit.setFavorite(makeFavorite);
                    InsertMultireddit.insertMultireddit(executor, handler, redditDataRoomDatabase, multiReddit,
                            favoriteMultiRedditListener::success);
                } else {
                    favoriteMultiRedditListener.failed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                favoriteMultiRedditListener.failed();
            }
        });
    }
}
