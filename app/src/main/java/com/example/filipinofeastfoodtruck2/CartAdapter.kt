package com.example.filipinofeastfoodtruck2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class CartAdapter(private val cartItems: MutableList<MenuItem>, private val onItemRemoved: () -> Unit) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuItemImage: ImageView = itemView.findViewById(R.id.cartItemImage)
        val menuItemName: TextView = itemView.findViewById(R.id.cartItemName)
        val menuItemPrice: TextView = itemView.findViewById(R.id.cartItemPrice)
        val removeButton: Button = itemView.findViewById(R.id.removeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]

        // Prevent crashes if image resource is invalid
        if (item.imageResource != 0) {
            holder.menuItemImage.setImageResource(item.imageResource)
        } else {
            holder.menuItemImage.setImageResource(R.drawable.ic_launcher_foreground)
        }

        holder.menuItemName.text = item.name

        // Makes sure price is properly formatted
        val price = item.price.replace("$", "").toDoubleOrNull() ?: 0.0
        holder.menuItemPrice.text = String.format(Locale.US, "$%.2f", price)

        // Remove item from cart when "Remove" button is clicked
        holder.removeButton.setOnClickListener {
            if (position < cartItems.size) {
                cartItems.removeAt(position)

                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cartItems.size)

                //Update CartManager correctly
                CartManager.updateCart(cartItems)

                //Makes sure total price updates
                onItemRemoved()  // Triggers updateTotalPrice() inside CartActivity
            }
        }


    }


    override fun getItemCount(): Int {
        return cartItems.size
    }
}
