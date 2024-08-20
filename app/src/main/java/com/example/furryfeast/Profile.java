package com.example.furryfeast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furryfeast.Model.User;

public class Profile extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView profileName, profileEmail;
    private Button logoutButton, homeButton, cartButton, eduButton, profileButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profilePicture = findViewById(R.id.profile_picture);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        logoutButton = findViewById(R.id.logout_button);
        homeButton = findViewById(R.id.homeBtn);
        cartButton = findViewById(R.id.cartBtn);
        eduButton = findViewById(R.id.eduBtn);
        profileButton = findViewById(R.id.profileBtn);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Fetch user email from session
        SharedPreferences sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE);
        String userEmail = sharedPreferences.getString("user_email", null);

        if (userEmail != null) {
            // Fetch user details
            User loggedInUser = dbHelper.getUserDetailsByEmail(userEmail);

            // Set user details to views
            profileName.setText(loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
            profileEmail.setText(loggedInUser.getEmail());
        }

        // Set an OnClickListener on the logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear user session
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                // Redirect to MainActivity
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Set OnClickListeners for navigation buttons
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Cart.class);
                startActivity(intent);
            }
        });

        eduButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, InfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
