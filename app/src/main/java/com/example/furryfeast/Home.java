package com.example.furryfeast;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.furryfeast.Adapter.ProductAdapter;
import com.example.furryfeast.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
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

        // Initialize product list and adapter
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(productAdapter);

        // Load products (you'll need to implement this method to fetch products from your database or API)
        loadProducts();
    }

    private void loadProducts() {
        // Dummy data for demonstration purposes
        productList.add(new Product("Product 1", "Description 1", 10.00, R.drawable.ic_launcher_background));
        productList.add(new Product("Product 2", "Description 2", 20.00, R.drawable.ic_launcher_background));

        // Notify the adapter about data changes
        productAdapter.notifyDataSetChanged();
    }
}
