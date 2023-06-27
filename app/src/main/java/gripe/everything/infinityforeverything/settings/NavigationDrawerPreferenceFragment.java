package gripe.everything.infinityforeverything.settings;

import android.os.Bundle;

import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import org.greenrobot.eventbus.EventBus;

import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.customviews.CustomFontPreferenceFragmentCompat;
import gripe.everything.infinityforeverything.events.ChangeHideKarmaEvent;
import gripe.everything.infinityforeverything.events.ChangeShowAvatarOnTheRightInTheNavigationDrawerEvent;
import gripe.everything.infinityforeverything.utils.SharedPreferencesUtils;

public class NavigationDrawerPreferenceFragment extends CustomFontPreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName(SharedPreferencesUtils.NAVIGATION_DRAWER_SHARED_PREFERENCES_FILE);
        setPreferencesFromResource(R.xml.navigation_drawer_preferences, rootKey);

        SwitchPreference showAvatarOnTheRightSwitch = findPreference(SharedPreferencesUtils.SHOW_AVATAR_ON_THE_RIGHT);
        SwitchPreference hideKarmaSwitch = findPreference(SharedPreferencesUtils.HIDE_ACCOUNT_KARMA_NAV_BAR);

        if (showAvatarOnTheRightSwitch != null) {
            showAvatarOnTheRightSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeShowAvatarOnTheRightInTheNavigationDrawerEvent((Boolean) newValue));
                return true;
            });
        }

        if (hideKarmaSwitch != null) {
            hideKarmaSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                EventBus.getDefault().post(new ChangeHideKarmaEvent((Boolean) newValue));
                return true;
            });
        }
    }
}