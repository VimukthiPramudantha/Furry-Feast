package com.example.furryfeast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.furryfeast.Model.User;
import com.example.furryfeast.DatabaseHelper;

public class Profile extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView profileName, profileEmail;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        profilePicture = findViewById(R.id.profile_picture);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);

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
    }
}
