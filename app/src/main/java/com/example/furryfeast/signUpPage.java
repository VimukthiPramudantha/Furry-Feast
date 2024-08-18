package com.example.furryfeast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signUpPage extends AppCompatActivity {

    private EditText firstNameInput, lastNameInput, emailInput, passwordInput;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        dbHelper = new DatabaseHelper(this);

        firstNameInput = findViewById(R.id.first_name_input);
        lastNameInput = findViewById(R.id.last_name_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameInput.getText().toString();
                String lastName = lastNameInput.getText().toString();
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signUpPage.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.addUser(firstName, lastName, email, password);
                    Toast.makeText(signUpPage.this, "User added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}