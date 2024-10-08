package com.example.furryfeast.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.furryfeast.DatabaseHelper;
import com.example.furryfeast.Model.Product;
import com.example.furryfeast.R;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Product> {

    private DatabaseHelper dbHelper;
    private List<Product> cartItems;
    private int userId;
    private SharedPreferences sharedPreferences;

    public CartAdapter(Context context, List<Product> cartItems) {
        super(context, 0, cartItems);
        this.cartItems = cartItems;
        dbHelper = new DatabaseHelper(context);
        sharedPreferences = context.getSharedPreferences("user_session", MODE_PRIVATE);
        this.userId = sharedPreferences.getInt("user_id",0);
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }

        Product product = getItem(position);

        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        TextView itemQuantity = convertView.findViewById(R.id.item_quantity);
        Button removeBtn = convertView.findViewById(R.id.removeBtn);

        if (product != null) {
            itemName.setText(product.getName());
            itemPrice.setText("$" + String.format("%.2f", product.getPrice()));
            itemQuantity.setText(String.valueOf(product.getQuantity()));

            removeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        dbHelper.removeCartItem(userId, product.getId());
                        cartItems.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(getContext(), "Item removed successfully!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "Error removing item: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        return convertView;
    }
}
