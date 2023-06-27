package gripe.everything.infinityforeverything.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import gripe.everything.infinityforeverything.Infinity;
import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.activities.BaseActivity;
import gripe.everything.infinityforeverything.adapters.TranslationFragmentRecyclerViewAdapter;
import gripe.everything.infinityforeverything.customtheme.CustomThemeWrapper;

public class TranslationFragment extends Fragment {

    @BindView(R.id.recycler_view_translation_fragment)
    RecyclerView recyclerView;
    @Inject
    CustomThemeWrapper customThemeWrapper;
    private BaseActivity activity;

    public TranslationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_translation, container, false);

        ((Infinity) activity.getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this, rootView);

        TranslationFragmentRecyclerViewAdapter adapter = new TranslationFragmentRecyclerViewAdapter(activity, customThemeWrapper);
        recyclerView.setAdapter(adapter);

        rootView.setBackgroundColor(customThemeWrapper.getBackgroundColor());

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;
    }
}