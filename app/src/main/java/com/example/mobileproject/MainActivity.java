package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. Inisialisasi komponen dari XML
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // 2. Memberikan aksi ketika tombol Login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil teks dari kolom input
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // 3. Logika Pengecekan Username dan Password
                if (username.equals("admin") && password.equals("admin")) {
                    // Jika benar, tampilkan pesan sukses dan pindah ke Landing Page
                    Toast.makeText(MainActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, LandingPageActivity.class);
                    startActivity(intent);

                    // finish() digunakan agar pengguna tidak bisa menekan tombol back ke halaman login lagi
                    finish();

                } else if (username.isEmpty() || password.isEmpty()) {
                    // Jika ada kolom yang dibiarkan kosong
                    Toast.makeText(MainActivity.this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show();

                } else {
                    // Jika username atau password salah
                    Toast.makeText(MainActivity.this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}