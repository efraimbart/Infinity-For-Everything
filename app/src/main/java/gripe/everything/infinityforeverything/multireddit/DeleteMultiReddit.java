package gripe.everything.infinityforeverything.multireddit;

import android.os.Handler;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.asynctasks.DeleteMultiredditInDatabase;
import gripe.everything.infinityforeverything.apis.RedditAPI;
import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.utils.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeleteMultiReddit {

    public interface DeleteMultiRedditListener {
        void success();
        void failed();
    }

    public static void deleteMultiReddit(Executor executor, Handler handler, Retrofit oauthRetrofit,
                                         RedditDataRoomDatabase redditDataRoomDatabase,
                                         String accessToken, String accountName, String multipath,
                                         DeleteMultiRedditListener deleteMultiRedditListener) {
        oauthRetrofit.create(RedditAPI.class).deleteMultiReddit(APIUtils.getOAuthHeader(accessToken),
                multipath).enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    DeleteMultiredditInDatabase.deleteMultiredditInDatabase(executor, handler, redditDataRoomDatabase, accountName, multipath,
                            deleteMultiRedditListener::success);
                } else {
                    deleteMultiRedditListener.failed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                deleteMultiRedditListener.failed();
            }
        });
    }
}
