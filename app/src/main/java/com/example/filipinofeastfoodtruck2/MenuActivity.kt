package com.example.filipinofeastfoodtruck2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageButton

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuRecyclerView: RecyclerView = findViewById(R.id.menuRecyclerView)
        menuRecyclerView.layoutManager = GridLayoutManager(this, 2)

        val menuList = listOf(
            MenuItem(name = "Silog", price = "$9.95", imageResource = R.drawable.silog, description = "Classic Filipino breakfast with garlic rice and egg."),
            MenuItem(name = "Kare-Kare", price = "$9.95", imageResource = R.drawable.karekare, description = "Peanut stew with oxtail and vegetables."),
            MenuItem(name = "Pancit", price = "$9.95", imageResource = R.drawable.pancit, description = "Filipino stir-fried noodles with vegetables and meat."),
            MenuItem(name = "Giniling", price = "$9.95", imageResource = R.drawable.giniling, description = "Ground pork stew with vegetables and tomato sauce."),
            MenuItem(name = "Can Soda", price = "$1.25", imageResource = R.drawable.soda, description = "Refreshing carbonated soft drink."),
            MenuItem(name = "Water", price = "$2.00", imageResource = R.drawable.water, description = "Bottled water."),
            MenuItem(name = "Flan", price = "$4.00", imageResource = R.drawable.flan, description = "Sweet caramel custard dessert."),
            MenuItem(name = "Ube Ice Cream", price = "$2.50", imageResource = R.drawable.ube_icecream, description = "Purple yam-flavored ice cream.")
        )


        menuRecyclerView.adapter = MenuAdapter(menuList)

        //Back Button
        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}


