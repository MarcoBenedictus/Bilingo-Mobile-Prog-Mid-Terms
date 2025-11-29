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

public class register extends AppCompatActivity {
    EditText txtdisplay;
    EditText txtpassword;
    EditText txtusername;
    ImageButton nextpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register); // Pastikan nama file XML-nya benar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtdisplay = findViewById(R.id.txtdisplay);
        txtpassword = findViewById(R.id.txtpassword);
        txtusername = findViewById(R.id.txtusername);
        nextpage2 = findViewById(R.id.nextpage2);

        nextpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });
    }

    private void performRegistration() {
        String username = txtusername.getText().toString().trim();
        String password = txtpassword.getText().toString().trim();
        String displayName = txtdisplay.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || displayName.isEmpty()) {
            Toast.makeText(this, "Tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {

            UserDataManager manager = UserDataManager.getInstance();
            boolean sukses = manager.registerUser(username, password, displayName);

            runOnUiThread(() -> {
                if (sukses) {
                    Toast.makeText(this, "Registrasi Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Username '" + username + "' sudah dipakai", Toast.LENGTH_SHORT).show();
                }
            });

        }).start();
    }
}