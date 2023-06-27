package gripe.everything.infinityforeverything.settings;


import android.os.Build;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.SwitchPreference;

import org.greenrobot.eventbus.EventBus;

import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.customviews.CustomFontPreferenceFragmentCompat;
import gripe.everything.infinityforeverything.events.ChangeHideFabInPostFeedEvent;
import gripe.everything.infinityforeverything.events.ChangeVoteButtonsPositionEvent;
import gripe.everything.infinityforeverything.events.RecreateActivityEvent;
import gripe.everything.infinityforeverything.utils.SharedPreferencesUtils;

public class InterfacePreferenceFragment extends CustomFontPreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.interface_preferences, rootKey);

        Preference immersiveInterfaceEntryPreference = findPreference(SharedPreferencesUtils.IMMERSIVE_INTERFACE_ENTRY_KEY);
        SwitchPreference hideFabInPostFeedSwitchPreference = findPreference(SharedPreferencesUtils.HIDE_FAB_IN_POST_FEED);
        SwitchPreference bottomAppBarSwitch = findPreference(SharedPreferencesUtils.BOTTOM_APP_BAR_KEY);
        SwitchPreference voteButtonsOnTheRightSwitch = findPreference(SharedPreferencesUtils.VOTE_BUTTONS_ON_THE_RIGHT_KEY);

        if (immersiveInterfaceEntryPreference != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            immersiveInterfaceEntryPreference.setVisible(true);
        }

        if (hideFabInPostFeedSwitchPreference != null) {
            hideFabInPostFeedSwitchPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeHideFabInPostFeedEvent((Boolean) newValue));
                return true;
            });
        }

        if (bottomAppBarSwitch != null) {
            bottomAppBarSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new RecreateActivityEvent());
                return true;
            });
        }

        if (voteButtonsOnTheRightSwitch != null) {
            voteButtonsOnTheRightSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeVoteButtonsPositionEvent((Boolean) newValue));
                return true;
            });
        }
    }
}
