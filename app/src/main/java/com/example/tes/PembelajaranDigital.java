package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class PembelajaranDigital extends Fragment {

    private EditText nameEditText;
    private Button addButton;
    private ListView contactListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> contacts = new ArrayList<>();

    public PembelajaranDigital() {
        // Required empty public constructor
    }

    public static PembelajaranDigital newInstance() {
        return new PembelajaranDigital();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pembelajaran_digital, container, false);

        nameEditText = rootView.findViewById(R.id.nameEditText);
        addButton = rootView.findViewById(R.id.addButton);
        contactListView = rootView.findViewById(R.id.contactListView);

        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, contacts);
        contactListView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if (!name.isEmpty()) {
                    contacts.add(name);
                    adapter.notifyDataSetChanged();
                    nameEditText.setText("");
                }
            }
        });

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Implement your Edit logic here
                // For example: start an edit activity/fragment
            }
        });

        contactListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                contacts.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        return rootView;
    }
}
