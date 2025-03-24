package com.example.filipinofeastfoodtruck2

object CartManager {
    private val cartItems = mutableListOf<MenuItem>()

    fun addToCart(item: MenuItem) {
        cartItems.add(item)
    }

    fun getCartItems(): List<MenuItem> {
        return cartItems
    }

    fun clearCart() {
        cartItems.clear()
    }

    //Update cart items properly
    fun updateCart(newCart: List<MenuItem>) {
        cartItems.clear()
        cartItems.addAll(newCart)
    }
}

