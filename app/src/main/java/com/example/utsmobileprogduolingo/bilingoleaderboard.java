package com.example.utsmobileprogduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class bilingoleaderboard extends AppCompatActivity {

    ImageButton navLearn, navChest, navTrophy, navHeart, navShop, navSettings;
    Button viewlb, viewprog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilingoleaderboard);
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

        navTrophy.setAlpha(0.5f);
        navTrophy.setOnClickListener(null);

        navLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingoleaderboard.this, home.class);
                startActivity(intent);
            }
        });

        // Quests
        navChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingoleaderboard.this, bilingoquest.class);
                startActivity(intent);
            }
        });

        // Feed
        navHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingoleaderboard.this, bilingofeed.class);
                startActivity(intent);
            }
        });

        // Shop
        navShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingoleaderboard.this, bilingostore.class);
                startActivity(intent);
            }
        });

        // Settings
        navSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bilingoleaderboard.this, bilingosettings.class);
                startActivity(intent);
            }
        });

        viewlb = findViewById(R.id.viewlb);
        viewprog = findViewById(R.id.viewprog);

        viewlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                bilingotrophyfrag1 frag = new bilingotrophyfrag1();
                ft.replace(R.id.frame, frag);
                ft.commit();
            }
        });

        viewprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame, new bilingotrophyfrag2());
                ft.commit();
            }
        });
    }
}
