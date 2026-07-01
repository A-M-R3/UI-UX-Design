package com.universitatcarlemany.activity2.controller

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.universitatcarlemany.activity2.R
import com.universitatcarlemany.activity2.adapter.MenuAdapter
import com.universitatcarlemany.activity2.repository.RestaurantRepository

class MenuActivity : AppCompatActivity() {

    private lateinit var repository: RestaurantRepository
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var restaurantNameText: TextView
    private lateinit var allergyInfoText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        repository = RestaurantRepository(this)
        menuRecyclerView = findViewById(R.id.menuRecyclerView)
        restaurantNameText = findViewById(R.id.detailRestaurantName)
        allergyInfoText = findViewById(R.id.detailAllergyInfo)

        menuRecyclerView.layoutManager = LinearLayoutManager(this)

        val restaurantId = intent.getStringExtra("RESTAURANT_ID")
        
        if (restaurantId != null) {
            val restaurant = repository.getRestaurantById(restaurantId)
            if (restaurant != null) {
                restaurantNameText.text = restaurant.getName()
                
                val menu = restaurant.getMenu()
                if (menu != null) {
                    allergyInfoText.text = menu.getAllergyInfo()
                    val menuItems = menu.getItems()
                    val adapter = MenuAdapter(menuItems)
                    menuRecyclerView.adapter = adapter
                }
            }
        }
    }
}