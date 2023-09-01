package com.example.tes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Settings extends Fragment {

    private RecyclerView chatRecyclerView;
    private EditText messageEditText;
    private Button liveChatButton;

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
        liveChatButton = rootView.findViewById(R.id.liveChatButton);
        chatRecyclerView = rootView.findViewById(R.id.chatRecyclerView);
        messageEditText = rootView.findViewById(R.id.messageEditText);

        // Pengaturan RecyclerView dan Adapter untuk chat
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        chatRecyclerView.setLayoutManager(layoutManager);
        // Buat adapter ChatAdapter sesuai kebutuhan

        liveChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleChatUI();
            }
        });

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

    // Metode untuk mengatur visibilitas elemen chat UI
    private void toggleChatUI() {
        if (chatRecyclerView.getVisibility() == View.VISIBLE) {
            chatRecyclerView.setVisibility(View.GONE);
            messageEditText.setVisibility(View.GONE);
        } else {
            chatRecyclerView.setVisibility(View.VISIBLE);
            messageEditText.setVisibility(View.VISIBLE);
        }
    }

    // Metode untuk memulai obrolan
    public void startChatRoom(View view) {
        // Implementasi untuk memulai obrolan atau navigasi ke halaman obrolan
    }
}
