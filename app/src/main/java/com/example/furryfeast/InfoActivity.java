package com.example.furryfeast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    private TextView title, educationalText;
    private ImageView educationalImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        title = findViewById(R.id.tvArticleTitle1);
        educationalText = findViewById(R.id.tvArticleContent1);
        educationalImage = findViewById(R.id.ivArticleImage1);
        Button homeBtn = findViewById(R.id.homeBtn);
        Button cartBtn = findViewById(R.id.cartBtn);
        Button profileBtn = findViewById(R.id.profileBtn);
        Button eduBtn = findViewById(R.id.eduBtn);

        title.setText("Dog Nutrition Tips");
        educationalText.setText("Proper nutrition is essential for the health and well-being of your dog...");
        educationalImage.setImageResource(R.drawable.article);

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, Home.class);
            startActivity(intent);
        });

        cartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, Cart.class);
            startActivity(intent);
        });

        profileBtn.setOnClickListener(v -> {
            Intent intent = new Intent(InfoActivity.this, Profile.class);
            startActivity(intent);
        });

    }
}
