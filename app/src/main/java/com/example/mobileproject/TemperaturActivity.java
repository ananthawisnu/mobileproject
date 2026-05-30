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

public class TemperaturActivity extends AppCompatActivity {

    private EditText etInput, etHasil;
    private Spinner spDari, spKe;
    private Button btnKonversi;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatur);

        btnBack = findViewById(R.id.btnBack);
        etInput = findViewById(R.id.etInputAngka);
        etHasil = findViewById(R.id.etHasil);
        spDari = findViewById(R.id.spinnerDari);
        spKe = findViewById(R.id.spinnerKe);
        btnKonversi = findViewById(R.id.btnKonversi);

        String[] units = {"Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)", "Reaumur (°R)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spDari.setAdapter(adapter);
        spKe.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnKonversi.setOnClickListener(v -> hitungKonversi());
    }

    private void hitungKonversi() {
        String inputStr = etInput.getText().toString();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "Harap masukkan angka", Toast.LENGTH_SHORT).show();
            return;
        }

        double val = Double.parseDouble(inputStr);
        String dari = spDari.getSelectedItem().toString();
        String ke = spKe.getSelectedItem().toString();
        double celsius = 0;

        // Step 1: Ubah Satuan Awal ke Celsius
        if (dari.contains("Celsius")) celsius = val;
        else if (dari.contains("Fahrenheit")) celsius = (val - 32) * 5 / 9;
        else if (dari.contains("Kelvin")) celsius = val - 273.15;
        else if (dari.contains("Reaumur")) celsius = val * 5 / 4;

        // Step 2: Ubah dari Celsius ke Satuan Tujuan
        double result = 0;
        if (ke.contains("Celsius")) result = celsius;
        else if (ke.contains("Fahrenheit")) result = (celsius * 9 / 5) + 32;
        else if (ke.contains("Kelvin")) result = celsius + 273.15;
        else if (ke.contains("Reaumur")) result = celsius * 4 / 5;

        String hasilFormat = String.format("%.2f", result);
        etHasil.setText(hasilFormat + " " + ke);
    }
}