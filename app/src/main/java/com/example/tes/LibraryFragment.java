package com.example.tes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;

public class LibraryFragment extends Fragment {

    private static final int PICK_IMAGE = 1;
    private EditText isinpm;
    private EditText isinama;
    private RadioGroup jk;
    private Spinner kelas;
    private Spinner agama;
    private EditText tempatlahir;
    private EditText tanggallahir;
    private Button simpan;
    private TextView hasil;
    private ImageView gambar;
    private Button uploadGambarButton;

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
        gambar = view.findViewById(R.id.gambar);
        uploadGambarButton = view.findViewById(R.id.uploadGambarButton);

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

        // Menambahkan event onClickListener ke tombol "Upload Gambar"
        uploadGambarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuka galeri untuk memilih gambar
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, PICK_IMAGE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();

                try {
                    // Mengubah URI gambar menjadi bitmap
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), selectedImageUri);

                    // Menampilkan gambar yang diunggah di ImageView
                    gambar.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
