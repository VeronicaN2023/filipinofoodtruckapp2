package com.example.filipinofeastfoodtruck2

object CartManager {
    private val cartItems = mutableListOf<MenuItem>()

    fun addToCart(item: MenuItem) {
        cartItems.add(item)
    }

    fun getCartItems(): List<MenuItem> {
        return cartItems
    }

    fun removeFromCart(item: MenuItem) {
        cartItems.remove(item)
    }

    fun clearCart() {
        cartItems.clear()
    }
}

