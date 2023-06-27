package gripe.everything.infinityforeverything.settings;

import android.os.Bundle;

import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.customviews.CustomFontPreferenceFragmentCompat;

public class SortTypePreferenceFragment extends CustomFontPreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.sort_type_preferences, rootKey);
    }
}