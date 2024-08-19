package com.example.furryfeast.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.furryfeast.R;

import com.example.furryfeast.Model.Product;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Product> {

    public CartAdapter(Context context, List<Product> cartItems) {
        super(context, 0, cartItems);
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

        if (product != null) {
            itemName.setText(product.getName());
            itemPrice.setText("$" + String.format("%.2f", product.getPrice()));
            itemQuantity.setText(String.valueOf(product.getQuantity()));
        }

        return convertView;
    }
}
