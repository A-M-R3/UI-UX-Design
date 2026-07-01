package com.universitatcarlemany.activity2.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.universitatcarlemany.activity2.model.Restaurant
import java.io.InputStreamReader

class RestaurantRepository(private val context: Context) {

    fun getRestaurants(): List<Restaurant> {
        val inputStream = context.assets.open("data/restaurants.json")
        val reader = InputStreamReader(inputStream)
        val itemType = object : TypeToken<List<Restaurant>>() {}.type
        return Gson().fromJson(reader, itemType)
    }

    fun getRestaurantById(id: String): Restaurant? {
        return getRestaurants().find { it.getName() == id }
    }
}