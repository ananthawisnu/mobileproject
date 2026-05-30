package com.example.mobileproject;

import android.content.Intent;
import android.health.connect.datatypes.units.Mass;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class KitConverterActivity extends AppCompatActivity {

    private ImageButton btnHome;
    private Button btnPanjang, btnBMI, btnMassa, btnTemperatur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_converter);

        // 1. Inisialisasi View
        btnHome = findViewById(R.id.btnHome);
        btnPanjang = findViewById(R.id.btnPanjang);
        btnBMI = findViewById(R.id.btnBMI);
        btnMassa = findViewById(R.id.btnMassa);
        btnTemperatur = findViewById(R.id.btnTemperatur);

        // 2. Aksi Tombol Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sesuai instruksi Anda: menekan tombol rumah kembali ke landing page
                finish();
            }
        });

        // 3. Aksi Tombol Panjang
        btnPanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman PanjangActivity
                Intent intent = new Intent(KitConverterActivity.this, PanjangActivity.class);
                startActivity(intent);
            }
        });

        // 4. Aksi Tombol Lainnya (Sementara memunculkan Toast sampai Activity-nya kita buat)
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KitConverterActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });

        btnMassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KitConverterActivity.this, MassaActivity.class);
                startActivity(intent);
            }
        });

        btnTemperatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(KitConverterActivity.this, TemperaturActivity.class);
              startActivity(intent);
            }
        });
    }
}