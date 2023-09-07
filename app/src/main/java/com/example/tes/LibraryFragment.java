package com.example.tes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;

public class LibraryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private EditText isinpm;
    private EditText isinama;
    private RadioGroup jk;
    private Spinner kelas;
    private Spinner agama;
    private EditText tempatlahir;
    private EditText tanggallahir;
    private Button simpan;
    private TextView hasil;

    public LibraryFragment() {
        // Required empty public constructor
    }

    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
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
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            HashMap<Integer, Runnable> itemActions = new HashMap<>();
            itemActions.put(R.id.bottom_home, () -> {
                // Tidak perlu melakukan apa-apa jika item home dipilih
            });
            itemActions.put(R.id.bottom_search, () -> {
                startActivity(new Intent(requireContext(), SearchActivity.class));
                requireActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                requireActivity().finish();
            });
            itemActions.put(R.id.bottom_settings, () -> {
                startActivity(new Intent(requireContext(), SettingsActivity.class));
                requireActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                requireActivity().finish();
            });
            itemActions.put(R.id.bottom_profile, () -> {
                startActivity(new Intent(requireContext(), ProfileActivity.class));
                requireActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                requireActivity().finish();
            });

            Runnable action = itemActions.get(item.getItemId());
            if (action != null) {
                action.run();
                return true;
            }
            return false;
        });

        // Inisialisasi elemen-elemen dari layout
        isinpm = view.findViewById(R.id.isinpm);
        isinama = view.findViewById(R.id.isinama);
        jk = view.findViewById(R.id.jk);
        kelas = view.findViewById(R.id.kelas);
        agama = view.findViewById(R.id.agama);
        tempatlahir = view.findViewById(R.id.tempatlahir);
        tanggallahir = view.findViewById(R.id.tanggallahir);
        simpan = view.findViewById(R.id.simpan);
        hasil = view.findViewById(R.id.hasil);

        // Menambahkan event onClickListener ke tombol "SIMPAN"
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil nilai dari elemen-elemen yang diisi oleh pengguna
                String npm = isinpm.getText().toString();
                String nama = isinama.getText().toString();
                String jenisKelamin = ((RadioButton) view.findViewById(jk.getCheckedRadioButtonId())).getText().toString();
                String kelasSelected = kelas.getSelectedItem().toString();
                String agamaSelected = agama.getSelectedItem().toString();
                String tempatLahir = tempatlahir.getText().toString();
                String tanggalLahir = tanggallahir.getText().toString();

                // Menampilkan hasil input ke dalam TextView "hasil"
                String hasilInput = "NPM: " + npm + "\nNama: " + nama + "\nJenis Kelamin: " + jenisKelamin
                        + "\nKelas: " + kelasSelected + "\nAgama: " + agamaSelected + "\nTempat Lahir: " + tempatLahir
                        + "\nTanggal Lahir: " + tanggalLahir;
                hasil.setText(hasilInput);
            }
        });

        return view;
    }
}
