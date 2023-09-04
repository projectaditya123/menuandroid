package com.example.tes;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class layout_student_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_student_table); // Mengatur layout XML

        // Mendapatkan referensi ke TableLayout dari XML layout
        TableLayout tableLayout = findViewById(R.id.layout_student_table);


        // Data yang akan dimasukkan ke dalam tabel
        String[][] data = {
                {"John Doe", "123456", "Engineering", "85"},
                {"Jane Smith", "789123", "Computer Science", "92"},
                // Tambahkan data lainnya di sini
        };

        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);

            for (String cellData : row) {
                TextView textView = new TextView(this);
                textView.setText(cellData);
                textView.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                textView.setPadding(8, 8, 8, 8);
                textView.setGravity(android.view.Gravity.END);
                tableRow.addView(textView);
            }

            tableLayout.addView(tableRow);
        }
    }
}
