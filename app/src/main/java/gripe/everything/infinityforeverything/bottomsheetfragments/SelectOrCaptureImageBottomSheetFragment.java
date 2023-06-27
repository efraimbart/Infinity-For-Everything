package gripe.everything.infinityforeverything.bottomsheetfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import gripe.everything.infinityforeverything.R;
import gripe.everything.infinityforeverything.activities.PostGalleryActivity;
import gripe.everything.infinityforeverything.customviews.LandscapeExpandedRoundedBottomSheetDialogFragment;
import gripe.everything.infinityforeverything.utils.Utils;

public class SelectOrCaptureImageBottomSheetFragment extends LandscapeExpandedRoundedBottomSheetDialogFragment {

    private PostGalleryActivity mActivity;

    public SelectOrCaptureImageBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_select_or_capture_image_bottom_sheet, container, false);

        TextView selectImageTextView = rootView.findViewById(R.id.select_image_text_view_select_or_capture_image_bottom_sheet_fragment);
        TextView captureImageTextView = rootView.findViewById(R.id.capture_image_text_view_select_or_capture_image_bottom_sheet_fragment);

        selectImageTextView.setOnClickListener(view -> {
            mActivity.selectImage();
            dismiss();
        });

        captureImageTextView.setOnClickListener(view -> {
            mActivity.captureImage();
            dismiss();
        });

        if (mActivity.typeface != null) {
            Utils.setFontToAllTextViews(rootView, mActivity.typeface);
        }

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (PostGalleryActivity) context;
    }
}