package com.example.utsmobileprogduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home extends AppCompatActivity {

    ImageButton navLearn, navChest, navTrophy, navHeart, navShop, navSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navLearn = findViewById(R.id.nav_learn);
        navChest = findViewById(R.id.nav_chest);
        navTrophy = findViewById(R.id.nav_trophy);
        navHeart = findViewById(R.id.nav_heart);
        navShop = findViewById(R.id.nav_shop);
        navSettings = findViewById(R.id.nav_settings);

        navLearn.setAlpha(0.5f);
        navLearn.setOnClickListener(null);

        navChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, bilingoquest.class);
                startActivity(intent);
            }
        });

        // Leaderboard
        navTrophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, bilingoleaderboard.class);
                startActivity(intent);
            }
        });

        // Feed
        navHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, bilingofeed.class);
                startActivity(intent);
            }
        });

        // Shop
        navShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, bilingostore.class);
                startActivity(intent);
            }
        });

        // Settings
        navSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, bilingosettings.class);
                startActivity(intent);
            }
        });
    }
}