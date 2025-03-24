package com.example.filipinofeastfoodtruck2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale


class CartActivity : AppCompatActivity() {
    private lateinit var cartAdapter: CartAdapter
    private lateinit var totalPriceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartRecyclerView: RecyclerView = findViewById(R.id.cartRecyclerView)
        totalPriceTextView = findViewById(R.id.totalPriceTextView)
        val checkoutButton: Button = findViewById(R.id.checkoutButton)
        val backButton: ImageButton = findViewById(R.id.backButtonCart)

        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        val cartItems = CartManager.getCartItems().toMutableList()

        cartAdapter = CartAdapter(cartItems) {
            updateTotalPrice()
        }
        cartRecyclerView.adapter = cartAdapter

        // Initial calculation of total price
        updateTotalPrice()

        // Checkout Button
        checkoutButton.setOnClickListener {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Thank you for your order!", Toast.LENGTH_LONG).show()
                CartManager.clearCart()
                cartItems.clear()
                cartAdapter.notifyDataSetChanged()
                updateTotalPrice() // Reset total price after checkout

                // Navigate back to main menu after checkout
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Back Button
        backButton.setOnClickListener {
            finish() // Takes back to the previous screen
        }
    }

    // Function to update the total price
    private fun updateTotalPrice() {
        val totalPrice = CartManager.getCartItems().sumOf {
            it.price.replace("$", "").toDoubleOrNull() ?: 0.0
        }

        totalPriceTextView.text = String.format(Locale.US, "Total: $%.2f", totalPrice)
    }


    override fun onResume() {
        super.onResume()
        cartAdapter.notifyDataSetChanged()
        updateTotalPrice() //Makes sure total is updated when returning to cart
    }
}

