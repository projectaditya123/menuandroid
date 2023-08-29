package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

public class Settings extends Fragment {

    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        RadioGroup radioGroupNotification = rootView.findViewById(R.id.radioGroupNotification);
        RadioButton radioButtonOn = rootView.findViewById(R.id.radioButtonOn);
        RadioButton radioButtonOff = rootView.findViewById(R.id.radioButtonOff);
        Button buttonSave = rootView.findViewById(R.id.buttonSave);

        // Load notification setting status here and set the appropriate radio button checked

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupNotification.getCheckedRadioButtonId();
                if (selectedId == R.id.radioButtonOn) {
                    // Handle enabling notifications
                    // You can save this status to shared preferences or any other storage mechanism
                } else if (selectedId == R.id.radioButtonOff) {
                    // Handle disabling notifications
                    // You can save this status to shared preferences or any other storage mechanism
                }
            }
        });

        return rootView;
    }
}
