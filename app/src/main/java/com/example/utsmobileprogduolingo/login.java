package com.example.utsmobileprogduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    EditText txtpassword2;
    EditText txtusername2;
    ImageButton nextpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtpassword2 = findViewById(R.id.txtpassword2);
        txtusername2 = findViewById(R.id.txtusername2);
        nextpage = findViewById(R.id.nextpage);

        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String username = txtusername2.getText().toString().trim();
        String password = txtpassword2.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {

            UserDataManager manager = UserDataManager.getInstance();
            boolean sukses = manager.loginUser(username, password);

            runOnUiThread(() -> {
                if (sukses) {
                    Toast.makeText(login.this, "Login Berhasil. Welcome, " + username, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(login.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            });

        }).start(); // 8. Jalankan thread-nya
    }
}