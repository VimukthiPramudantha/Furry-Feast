package com.example.furryfeast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furryfeast.Adapter.ProductAdapter;
import com.example.furryfeast.Model.Product;

import java.util.List;

public class Home extends AppCompatActivity implements ProductAdapter.OnAddToCartClickListener {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private DatabaseHelper dbHelper;
    private int userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Retrieve the user ID from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE);
        userId = sharedPreferences.getInt("user_id", -1);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Load products from database
        loadProducts();
        setupButtonListeners();
    }

    private void loadProducts() {
        // Retrieve products from the database
        productList = dbHelper.getAllProducts();

        // Initialize adapter with product list and callback
        productAdapter = new ProductAdapter(productList, this, this);
        recyclerView.setAdapter(productAdapter);
    }

    private void setupButtonListeners() {
        Button homeBtn = findViewById(R.id.homeBtn);
        Button cartBtn = findViewById(R.id.cartBtn);
        Button eduBtn = findViewById(R.id.eduBtn);
        Button profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> {
            // Optional: Navigate to Home again
        });

        cartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, Cart.class);
            startActivity(intent);
        });

        eduBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, InfoActivity.class);
            startActivity(intent);
        });

        profileBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        });
    }

    @Override
    public void onAddToCartClick(Product product) {
        // Handle add to cart action
        int quantity = 1; // Default quantity
       dbHelper.addCartItem(userId, product.getId(), quantity);
        Toast.makeText(this, "Item added to Cart!", Toast.LENGTH_SHORT).show();


    }
}
