package com.example.tes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class ShortsFragment extends Fragment {

    private EditText nameEditText;
    private Button addButton;
    private EditText searchEditText;
    private ListView nameListView;
    private ArrayList<String> nameList;
    private ArrayAdapter<String> adapter;
    private View rootView;
    private Button darkModeButton;
    private boolean isDarkMode = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shorts, container, false);

        nameEditText = rootView.findViewById(R.id.nameEditText);
        addButton = rootView.findViewById(R.id.addButton);
        searchEditText = rootView.findViewById(R.id.searchEditText);
        nameListView = rootView.findViewById(R.id.nameListView);
        darkModeButton = rootView.findViewById(R.id.darkModeButton);

        nameList = new ArrayList<>();
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, nameList);
        nameListView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = nameEditText.getText().toString();
                if (!newName.isEmpty()) {
                    nameList.add(newName);
                    adapter.notifyDataSetChanged();
                    nameEditText.getText().clear();
                }
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

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
            rootView.setBackgroundColor(getResources().getColor(R.color.background_dark));
            // Update other UI elements for dark mode
        } else {
            rootView.setBackgroundColor(getResources().getColor(R.color.background_light));
            // Update other UI elements for light mode
        }
    }
}
