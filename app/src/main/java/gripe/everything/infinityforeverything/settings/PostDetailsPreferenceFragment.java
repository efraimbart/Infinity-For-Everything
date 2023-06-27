package gripe.everything.infinityforeverything.settings;

import android.os.Bundle;

import androidx.preference.PreferenceManager;

import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.customviews.CustomFontPreferenceFragmentCompat;
import gripe.everything.infinityforeverything.utils.SharedPreferencesUtils;

public class PostDetailsPreferenceFragment extends CustomFontPreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName(SharedPreferencesUtils.POST_DETAILS_SHARED_PREFERENCES_FILE);
        setPreferencesFromResource(R.xml.post_details_preferences, rootKey);
    }
}
