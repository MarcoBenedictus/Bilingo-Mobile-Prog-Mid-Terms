package com.example.utsmobileprogduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bilingosettings extends AppCompatActivity {

    ImageButton navLearn, navChest, navTrophy, navHeart, navShop, navSettings;
    TextView displayBundle, userBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilingosettings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        displayBundle = findViewById(R.id.displaybundle);
        userBundle = findViewById(R.id.userbundle);

        loadUserData();

        navLearn = findViewById(R.id.nav_learn);
        navChest = findViewById(R.id.nav_chest);
        navTrophy = findViewById(R.id.nav_trophy);
        navHeart = findViewById(R.id.nav_heart);
        navShop = findViewById(R.id.nav_shop);
        navSettings = findViewById(R.id.nav_settings);

        navSettings.setAlpha(0.5f);
        navSettings.setOnClickListener(null);

        navChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingosettings.this, bilingoquest.class);
                startActivity(intent);
            }
        });

        // Leaderboard
        navTrophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingosettings.this, bilingoleaderboard.class);
                startActivity(intent);
            }
        });

        // Feed
        navHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingosettings.this, bilingofeed.class);
                startActivity(intent);
            }
        });

        // Shop
        navShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingosettings.this, bilingostore.class);
                startActivity(intent);
            }
        });

        // Settings
        navLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingosettings.this, home.class);
                startActivity(intent);
            }
        });
    }

    private void loadUserData() {
        UserDataManager manager = UserDataManager.getInstance();
        String currentUsername = manager.getLoggedInUser();
        String currentDisplayName = manager.getLoggedInDisplayName();

        if (currentUsername != null) {
            userBundle.setText(currentUsername);
        } else {
            userBundle.setText("username_error");
        }

        if (currentDisplayName != null) {
            displayBundle.setText(currentDisplayName);
        } else {
            displayBundle.setText("display_name_error");
        }
    }
}

