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

        // Initialize views
        title = findViewById(R.id.title);
        educationalText = findViewById(R.id.educational_text);
        educationalImage = findViewById(R.id.educational_image);
        Button homeBtn = findViewById(R.id.homeBtn);
        Button cartBtn = findViewById(R.id.cartBtn);
        Button profileBtn = findViewById(R.id.profileBtn);
        Button eduBtn = findViewById(R.id.eduBtn);

        // Set educational content programmatically (if needed)
        title.setText("Dog Nutrition Tips");
        educationalText.setText("Proper nutrition is essential for the health and well-being of your dog. Make sure to provide a balanced diet with the right mix of proteins, fats, carbohydrates, vitamins, and minerals.");
        educationalImage.setImageResource(R.drawable.img);

        // Set OnClickListener for buttons to navigate to other activities
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

        eduBtn.setOnClickListener(v -> {
            // Info button clicked, do nothing or refresh the current activity
        });
    }
}
