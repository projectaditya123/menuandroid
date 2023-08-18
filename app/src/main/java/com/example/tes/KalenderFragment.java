package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class KalenderFragment extends Fragment {

    private CalendarView calendarView;
    private TimePicker timePicker;
    private RadioGroup radioGroup;
    private TextView dateTimeTextView;

    public KalenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kalender, container, false);

        calendarView = rootView.findViewById(R.id.calendarview);
        timePicker = rootView.findViewById(R.id.timepicker);
        radioGroup = rootView.findViewById(R.id.radioGroup);
        dateTimeTextView = rootView.findViewById(R.id.dateTimeTextView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                updateTimeAndDate(year, month, dayOfMonth, timePicker.getHour(), timePicker.getMinute());
            }
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                updateTimeAndDate(calendarView.getDate(), hourOfDay, minute);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radiocalendar) {
                    calendarView.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.GONE);
                } else if (checkedId == R.id.radioTime) {
                    calendarView.setVisibility(View.GONE);
                    timePicker.setVisibility(View.VISIBLE);
                }
            }
        });

        // Set initial selected date and time
        int initialYear = 2023;
        int initialMonth = 7; // 0-based (August is 7)
        int initialDay = 18;
        int initialHour = 12;
        int initialMinute = 0;

        calendarView.setDate(new Date(initialYear - 1900, initialMonth, initialDay).getTime(), true, true);
        timePicker.setHour(initialHour);
        timePicker.setMinute(initialMinute);
        updateTimeAndDate(initialYear, initialMonth, initialDay, initialHour, initialMinute);

        return rootView;
    }

    private void updateTimeAndDate(long date, int hourOfDay, int minute) {
    }

    private void updateTimeAndDate(int year, int month, int day, int hour, int minute) {
        String selectedDate = (month + 1) + "/" + day + "/" + year;
        String selectedDay = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date(year - 1900, month, day));
        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
        dateTimeTextView.setText("Selected Date and Time: " + selectedDate + " (" + selectedDay + ")" + " " + selectedTime);
    }
}
