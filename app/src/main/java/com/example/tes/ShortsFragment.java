package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShortsFragment extends Fragment {

    private boolean isDarkMode = false;
    private View rootView;
    private Button darkModeButton;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ShortsFragment() {
        // Required empty public constructor
    }

    public static ShortsFragment newInstance(String param1, String param2) {
        ShortsFragment fragment = new ShortsFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shorts, container, false);
        darkModeButton = rootView.findViewById(R.id.darkModeButton);

        darkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDarkMode = !isDarkMode;
                updateUI();
            }
        });

        return rootView;
    }

    private void updateUI() {
        if (isDarkMode) {
            rootView.setBackgroundColor(getResources().getColor(R.color.background_dark)); // Set dark mode background color
            // Update other UI elements for dark mode
        } else {
            rootView.setBackgroundColor(getResources().getColor(R.color.background_light)); // Set light mode background color
            // Update other UI elements for light mode
        }
    }
}
