package com.example.tes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Informasi extends Fragment {

    private EditText editTextName;
    private RadioGroup radioGroupStatus;
    private RadioButton radioButtonPositive, radioButtonNegative;
    private Button buttonCalculate;
    private TextView textViewResult;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Informasi() {
        // Required empty public constructor
    }

    public static Informasi newInstance(String param1, String param2) {
        Informasi fragment = new Informasi();
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
        View rootView = inflater.inflate(R.layout.fragment_informasi, container, false);

        editTextName = rootView.findViewById(R.id.editTextName);
        radioGroupStatus = rootView.findViewById(R.id.radioGroupStatus);
        radioButtonPositive = rootView.findViewById(R.id.radioButtonPositive);
        radioButtonNegative = rootView.findViewById(R.id.radioButtonNegative);
        buttonCalculate = rootView.findViewById(R.id.buttonCalculate);
        textViewResult = rootView.findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int value = 0;

                if (radioButtonPositive.isChecked()) {
                    value = 5;
                } else if (radioButtonNegative.isChecked()) {
                    value = -5;
                }

                int result = value;

                textViewResult.setText("Hasil untuk " + name + ": " + result);
            }
        });

        return rootView;
    }
}
