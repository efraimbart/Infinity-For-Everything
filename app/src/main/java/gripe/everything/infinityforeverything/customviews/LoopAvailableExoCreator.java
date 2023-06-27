package gripe.everything.infinityforeverything.customviews;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;

import gripe.everything.infinityforeverything.utils.SharedPreferencesUtils;
import gripe.everything.infinityforeverything.videoautoplay.Config;
import gripe.everything.infinityforeverything.videoautoplay.DefaultExoCreator;
import gripe.everything.infinityforeverything.videoautoplay.ToroExo;

public class LoopAvailableExoCreator extends DefaultExoCreator {
    private final SharedPreferences sharedPreferences;

    public LoopAvailableExoCreator(@NonNull ToroExo toro, @NonNull Config config, SharedPreferences sharedPreferences) {
        super(toro, config);
        this.sharedPreferences = sharedPreferences;
    }

    @NonNull
    @Override
    public ExoPlayer createPlayer() {
        ExoPlayer player = super.createPlayer();
        if (sharedPreferences.getBoolean(SharedPreferencesUtils.LOOP_VIDEO, true)) {
            player.setRepeatMode(Player.REPEAT_MODE_ALL);
        } else {
            player.setRepeatMode(Player.REPEAT_MODE_OFF);
        }

        return player;
    }
}
