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

public class MassaActivity extends AppCompatActivity {

    private EditText etInputAngka, etHasil;
    private Spinner spinnerDari, spinnerKe;
    private Button btnKonversi;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massa);

        // Inisialisasi View dari XML
        btnBack = findViewById(R.id.btnBack);
        etInputAngka = findViewById(R.id.etInputAngka);
        etHasil = findViewById(R.id.etHasil);
        spinnerDari = findViewById(R.id.spinnerDari);
        spinnerKe = findViewById(R.id.spinnerKe);
        btnKonversi = findViewById(R.id.btnKonversi);

        // Setup item untuk Spinner
        String[] units = {"Ton (t)", "Kilogram (kg)", "Gram (g)", "Miligram (mg)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spinnerDari.setAdapter(adapter);
        spinnerKe.setAdapter(adapter);

        // Fungsi Tombol Back
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

        // Tahap 1: Konversi input dari satuan awal menjadi Gram (satuan dasar)
        double inGram = 0;
        if (dari.contains("Ton")) {
            inGram = val * 1000000;
        } else if (dari.contains("Kilogram")) {
            inGram = val * 1000;
        } else if (dari.contains("Gram (g)")) {
            inGram = val;
        } else if (dari.contains("Miligram")) {
            inGram = val / 1000;
        }

        // Tahap 2: Konversi dari Gram ke satuan tujuan yang dipilih
        double result = 0;
        if (ke.contains("Ton")) {
            result = inGram / 1000000;
        } else if (ke.contains("Kilogram")) {
            result = inGram / 1000;
        } else if (ke.contains("Gram (g)")) {
            result = inGram;
        } else if (ke.contains("Miligram")) {
            result = inGram * 1000;
        }

        // Format hasil maksimal 4 angka desimal di belakang koma
        String hasilFormat = String.format("%.4f", result);

        // Tampilkan hasil akhir beserta satuannya
        etHasil.setText(hasilFormat + " " + ke);
    }
}