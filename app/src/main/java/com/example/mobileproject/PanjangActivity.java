package com.example.mobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PanjangActivity extends AppCompatActivity {

    private EditText etInputAngka, etHasil;
    private Spinner spinnerDari, spinnerKe;
    private Button btnKonversi;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panjang);

        // Inisialisasi View dari XML
        btnBack = findViewById(R.id.btnBack);
        etInputAngka = findViewById(R.id.etInputAngka);
        etHasil = findViewById(R.id.etHasil);
        spinnerDari = findViewById(R.id.spinnerDari);
        spinnerKe = findViewById(R.id.spinnerKe);
        btnKonversi = findViewById(R.id.btnKonversi);

        // Setup item untuk Spinner
        String[] units = {"Kilometer (km)", "Meter (m)", "Sentimeter (cm)", "Milimeter (mm)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spinnerDari.setAdapter(adapter);
        spinnerKe.setAdapter(adapter);

        // Fungsi Tombol Back (Kembali ke Kit Converter)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Fungsi Tombol Konversi
        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungKonversi();
            }
        });
    }

    private void hitungKonversi() {
        String inputStr = etInputAngka.getText().toString();

        // Validasi input kosong
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Harap masukkan angka terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double val = Double.parseDouble(inputStr);
        String dari = spinnerDari.getSelectedItem().toString();
        String ke = spinnerKe.getSelectedItem().toString();

        // Tahap 1: Konversi input dari satuan awal menjadi Meter (satuan dasar)
        double inMeter = 0;
        if (dari.contains("Kilometer")) {
            inMeter = val * 1000;
        } else if (dari.contains("Meter (m)")) {
            inMeter = val;
        } else if (dari.contains("Sentimeter")) {
            inMeter = val / 100;
        } else if (dari.contains("Milimeter")) {
            inMeter = val / 1000;
        }

        // Tahap 2: Konversi dari Meter ke satuan tujuan yang dipilih
        double result = 0;
        if (ke.contains("Kilometer")) {
            result = inMeter / 1000;
        } else if (ke.contains("Meter (m)")) {
            result = inMeter;
        } else if (ke.contains("Sentimeter")) {
            result = inMeter * 100;
        } else if (ke.contains("Milimeter")) {
            result = inMeter * 1000;
        }

        // Format hasil maksimal 4 angka desimal di belakang koma (opsional, agar rapi)
        String hasilFormat = String.format("%.4f", result);

        // Tampilkan hasil akhir beserta satuannya (menggunakan + " " + ke)
        etHasil.setText(hasilFormat + " " + ke);
    }
}