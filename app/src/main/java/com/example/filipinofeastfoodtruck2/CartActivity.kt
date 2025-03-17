package com.example.filipinofeastfoodtruck2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartRecyclerView: RecyclerView = findViewById(R.id.cartRecyclerView)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)

        val cartItems = CartManager.getCartItems().toMutableList()

        cartAdapter = CartAdapter(cartItems)
        cartRecyclerView.adapter = cartAdapter

        // Back Button Functionality
        val backButton: ImageButton = findViewById(R.id.backButtonCart)
        backButton.setOnClickListener {
            finish() // Takes user back to the previous screen
        }

        // Checkout Button
        val checkoutButton: Button = findViewById(R.id.checkoutButton)
        checkoutButton.setOnClickListener {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thank you for your order!", Toast.LENGTH_LONG).show()
                CartManager.clearCart()
                cartItems.clear()
                cartAdapter.notifyDataSetChanged()

                // Navigate back to main menu after checkout
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        cartAdapter.notifyDataSetChanged()
    }
}
