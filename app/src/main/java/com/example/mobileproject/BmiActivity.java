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

public class BmiActivity extends AppCompatActivity {

    private EditText etBerat, etTinggi, etUmur, etHasilBmi;
    private Spinner spinnerGender;
    private Button btnHitung;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // 1. Inisialisasi View
        btnBack = findViewById(R.id.btnBack);
        etBerat = findViewById(R.id.etBerat);
        etTinggi = findViewById(R.id.etTinggi);
        etUmur = findViewById(R.id.etUmur);
        etHasilBmi = findViewById(R.id.etHasilBmi);
        spinnerGender = findViewById(R.id.spinnerGender);
        btnHitung = findViewById(R.id.btnHitung);

        // 2. Setup Spinner Gender
        String[] genders = {"Laki-laki", "Perempuan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genders);
        spinnerGender.setAdapter(adapter);

        // 3. Tombol Back (Kembali ke Kit Converter)
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 4. Tombol Hitung BMI
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungBMI();
            }
        });
    }

    private void hitungBMI() {
        String beratStr = etBerat.getText().toString();
        String tinggiStr = etTinggi.getText().toString();
        String umurStr = etUmur.getText().toString();

        // Validasi jika ada form yang kosong
        if (beratStr.isEmpty() || tinggiStr.isEmpty() || umurStr.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double berat = Double.parseDouble(beratStr);
        double tinggiCm = Double.parseDouble(tinggiStr);

        // Rumus BMI menggunakan satuan Tinggi dalam Meter: berat (kg) / (tinggi (m) ^ 2)
        double tinggiM = tinggiCm / 100;
        double bmi = berat / (tinggiM * tinggiM);

        // Menentukan Kategori berdasarkan standar kesehatan umum
        String kategori;
        if (bmi < 18.5) {
            kategori = "Kurus (Kekurangan Berat Badan)";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            kategori = "Normal (Ideal)";
        } else if (bmi >= 25.0 && bmi < 29.9) {
            kategori = "Kelebihan Berat Badan";
        } else {
            kategori = "Obesitas";
        }

        // Format skor BMI menjadi 1 angka di belakang koma (contoh: 22.5)
        String skorBmiFormat = String.format("%.1f", bmi);

        // Tampilkan hasil gabungan skor dan kategori ke form hasil
        etHasilBmi.setText(skorBmiFormat + " - " + kategori);
    }
}