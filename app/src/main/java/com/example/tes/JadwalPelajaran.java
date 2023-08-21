package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

public class JadwalPelajaran extends Fragment {

    private Spinner spinnerSubjects;
    private Button buttonSubmit;
    private TextView textViewResult;

    private DatePicker datePicker;
    private TimePicker timePicker;
    private Spinner spinnerDays;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public JadwalPelajaran() {
        // Required empty public constructor
    }

    public static JadwalPelajaran newInstance(String param1, String param2) {
        JadwalPelajaran fragment = new JadwalPelajaran();
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
        View rootView = inflater.inflate(R.layout.fragment_jadwal_pelajaran, container, false);

        spinnerSubjects = rootView.findViewById(R.id.spinnerSubjects);
        buttonSubmit = rootView.findViewById(R.id.buttonSubmit);
        textViewResult = rootView.findViewById(R.id.textViewResult);

        datePicker = rootView.findViewById(R.id.datePicker);
        timePicker = rootView.findViewById(R.id.timePicker);
        spinnerDays = rootView.findViewById(R.id.spinnerDays);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.subjects,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        ArrayAdapter<CharSequence> daysAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.days,
                android.R.layout.simple_spinner_item
        );
        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDays.setAdapter(daysAdapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedSubject = spinnerSubjects.getSelectedItem().toString();
                int selectedDayPosition = spinnerDays.getSelectedItemPosition();
                String selectedDay = getResources().getStringArray(R.array.days)[selectedDayPosition];

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // Month is 0-based
                int year = datePicker.getYear();

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String dateTime = day + "/" + month + "/" + year + " " + hour + ":" + minute;

                textViewResult.setText("Selected subject: " + selectedSubject +
                        "\nSelected day: " + selectedDay +
                        "\nSelected date and time: " + dateTime);
            }
        });

        return rootView;
    }
}
