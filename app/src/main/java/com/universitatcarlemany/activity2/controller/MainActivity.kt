package com.universitatcarlemany.activity2.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.universitatcarlemany.activity2.R
import com.universitatcarlemany.activity2.adapter.RestaurantsAdapter
import com.universitatcarlemany.activity2.repository.RestaurantRepository

class MainActivity : AppCompatActivity() {

    private lateinit var repository: RestaurantRepository
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = RestaurantRepository(this)
        recyclerView = findViewById(R.id.restaurantsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val restaurants = repository.getRestaurants()
        
        val adapter = RestaurantsAdapter(restaurants) { selectedRestaurant ->
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RESTAURANT_ID", selectedRestaurant.getName())
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}