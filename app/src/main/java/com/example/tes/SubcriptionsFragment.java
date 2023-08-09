package com.example.tes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class SubcriptionsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public SubcriptionsFragment() {
        // Required empty public constructor
    }

    public static SubcriptionsFragment newInstance(String param1, String param2) {
        SubcriptionsFragment fragment = new SubcriptionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subcriptions, container, false);

        ImageSlider imageSlider = rootView.findViewById(R.id.imageSlider);

        ArrayList<SlideModelWithUrl> slideModels = new ArrayList<>();
        slideModels.add(new SlideModelWithUrl(R.drawable.image1, "https://www.youtube.com/", "Youtube"));
        slideModels.add(new SlideModelWithUrl(R.drawable.image2, "https://www.youtube.com/", "Youtube"));
        slideModels.add(new SlideModelWithUrl(R.drawable.image3, "https://id-id.facebook.com/", "Facebook"));
        slideModels.add(new SlideModelWithUrl(R.drawable.image4, "https://www.google.com/?hl=ID", "Google"));
        slideModels.add(new SlideModelWithUrl(R.drawable.image5, "https://www.google.com/?hl=ID", "Google"));

        ArrayList<SlideModel> imageSliderModels = new ArrayList<>();
        for (SlideModelWithUrl model : slideModels) {
            imageSliderModels.add(new SlideModel(model.getImageRes(), model.getDisplayText(), ScaleTypes.FIT));
        }

        imageSlider.setImageList(imageSliderModels, ScaleTypes.FIT);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                String url = slideModels.get(position).getImageUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
