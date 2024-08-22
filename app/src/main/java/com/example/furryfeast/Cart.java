package com.example.furryfeast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furryfeast.Adapter.CartAdapter;
import com.example.furryfeast.Model.Product;

import java.util.List;

public class Cart extends AppCompatActivity {

    private DatabaseHelper db;
    private ListView cartListView;
    private CartAdapter adapter;
    private List<Product> cartList;
    private Button order;
    private int userId; // Assuming this is passed from previous activity
    private TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        db = new DatabaseHelper(this);
        cartListView = findViewById(R.id.cart_list_view);
        totalAmount = findViewById(R.id.total_amount);
        order = findViewById(R.id.checkout_button);

        userId = getSharedPreferences("user_session", MODE_PRIVATE).getInt("user_id", -1);
        cartList = db.getCartItemsByUserId(userId);
        adapter = new CartAdapter(this, cartList);
        cartListView.setAdapter(adapter);

        order.setOnClickListener(v->{ Toast.makeText(Cart.this,"Order Proceed successfully",Toast.LENGTH_SHORT).show();});

        updateTotalAmount();
    }

    private void updateTotalAmount() {
        double total = 0.0;
        for (Product product : cartList) {
            total += product.getPrice() * product.getQuantity();
        }
        totalAmount.setText("$" + String.format("%.2f", total));
    }


}
