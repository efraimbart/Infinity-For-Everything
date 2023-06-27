package gripe.everything.infinityforeverything.asynctasks;

import android.content.SharedPreferences;
import android.os.Handler;

import java.util.concurrent.Executor;

import gripe.everything.infinityforeverything.RedditDataRoomDatabase;
import gripe.everything.infinityforeverything.customtheme.CustomTheme;
import gripe.everything.infinityforeverything.utils.CustomThemeSharedPreferencesUtils;

public class InsertCustomTheme {

    public static void insertCustomTheme(Executor executor, Handler handler,
                                         RedditDataRoomDatabase redditDataRoomDatabase,
                                         SharedPreferences lightThemeSharedPreferences,
                                         SharedPreferences darkThemeSharedPreferences,
                                         SharedPreferences amoledThemeSharedPreferences,
                                         CustomTheme customTheme, boolean checkDuplicate,
                                         InsertCustomThemeListener insertCustomThemeListener) {
        executor.execute(() -> {
            CustomTheme previousTheme = redditDataRoomDatabase.customThemeDao().getCustomTheme(customTheme.name);

            if (checkDuplicate && previousTheme != null) {
                handler.post(insertCustomThemeListener::duplicate);
            } else {
                if (customTheme.isLightTheme) {
                    redditDataRoomDatabase.customThemeDao().unsetLightTheme();
                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(customTheme, lightThemeSharedPreferences);
                } else if (previousTheme != null && previousTheme.isLightTheme) {
                    lightThemeSharedPreferences.edit().clear().apply();
                }
                if (customTheme.isDarkTheme) {
                    redditDataRoomDatabase.customThemeDao().unsetDarkTheme();
                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(customTheme, darkThemeSharedPreferences);
                } else if (previousTheme != null && previousTheme.isDarkTheme) {
                    darkThemeSharedPreferences.edit().clear().apply();
                }
                if (customTheme.isAmoledTheme) {
                    redditDataRoomDatabase.customThemeDao().unsetAmoledTheme();
                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(customTheme, amoledThemeSharedPreferences);
                } else if (previousTheme != null && previousTheme.isAmoledTheme) {
                    amoledThemeSharedPreferences.edit().clear().apply();
                }
                redditDataRoomDatabase.customThemeDao().insert(customTheme);

                handler.post(insertCustomThemeListener::success);
            }
        });
    }

    public interface InsertCustomThemeListener {
        void success();
        default void duplicate() {}
    }
}
