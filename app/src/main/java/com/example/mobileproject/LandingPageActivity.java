package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {

    private Button btnKitConverter, btnKatalogHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        // Inisialisasi Tombol berdasarkan ID di XML
        btnKitConverter = findViewById(R.id.btnKitConverter);
        btnKatalogHT = findViewById(R.id.btnKatalogHT);

        // Aksi ketika tombol Kit Converter ditekan
        btnKitConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Berpindah ke KitConverterActivity
                Intent intent = new Intent(LandingPageActivity.this, KitConverterActivity.class);
                startActivity(intent);
            }
        });

        // Aksi ketika tombol Katalog HT Analog ditekan
        btnKatalogHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan pesan pop-up sementara karena halaman belum dibuat
                Toast.makeText(LandingPageActivity.this, "Halaman Katalog HT Analog belum tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }
}