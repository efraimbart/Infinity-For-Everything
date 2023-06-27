package gripe.everything.infinityforeverything.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.customtheme.CustomTheme;
import gripe.everything.infinityforeverything.utils.CustomThemeSharedPreferencesUtils;

public class GetCustomTheme {
    public static void getCustomTheme(Executor executor, Handler handler,
                                      RedditDataRoomDatabase redditDataRoomDatabase,
                                      String customThemeName,
                                      GetCustomThemeListener getCustomThemeListener) {
        executor.execute(() -> {
            CustomTheme customTheme = redditDataRoomDatabase.customThemeDao().getCustomTheme(customThemeName);
            handler.post(() -> getCustomThemeListener.success(customTheme));
        });
    }

    public static void getCustomTheme(Executor executor, Handler handler,
                                      RedditDataRoomDatabase redditDataRoomDatabase,
                                      int themeType,
                                      GetCustomThemeListener getCustomThemeListener) {
        executor.execute(() -> {
            CustomTheme customTheme;
            switch (themeType) {
                case CustomThemeSharedPreferencesUtils.DARK:
                    customTheme = redditDataRoomDatabase.customThemeDao().getDarkCustomTheme();
                    break;
                case CustomThemeSharedPreferencesUtils.AMOLED:
                    customTheme = redditDataRoomDatabase.customThemeDao().getAmoledCustomTheme();
                    break;
                default:
                    customTheme = redditDataRoomDatabase.customThemeDao().getLightCustomTheme();
            }
            handler.post(() -> getCustomThemeListener.success(customTheme));
        });
    }

    public interface GetCustomThemeListener {
        void success(CustomTheme customTheme);
    }
}
