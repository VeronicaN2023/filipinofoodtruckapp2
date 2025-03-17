package com.example.filipinofeastfoodtruck2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuItemImage: ImageView = itemView.findViewById(R.id.menuItemImage)
        val menuItemName: TextView = itemView.findViewById(R.id.menuItemName)
        val menuItemPrice: TextView = itemView.findViewById(R.id.menuItemPrice)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuList[position]
        holder.menuItemImage.setImageResource(menuItem.imageResource)
        holder.menuItemName.text = menuItem.name
        holder.menuItemPrice.text = menuItem.price
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}



