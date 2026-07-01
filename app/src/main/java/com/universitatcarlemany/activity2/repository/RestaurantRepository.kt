package com.universitatcarlemany.activity2.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.universitatcarlemany.activity2.model.Restaurant
import com.universitatcarlemany.activity2.model.RestaurantResponse
import com.universitatcarlemany.activity2.util.LocalTimeAdapter
import java.io.InputStreamReader
import java.time.LocalTime

class RestaurantRepository(private val context: Context) {

    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalTime::class.java, LocalTimeAdapter())
        .create()

    fun getRestaurants(): List<Restaurant> {
        val inputStream = context.assets.open("data/restaurants.json")
        val reader = InputStreamReader(inputStream)
        val response = gson.fromJson(reader, RestaurantResponse::class.java)
        return response.getRestaurants()
    }

    fun getRestaurantById(id: String): Restaurant? {
        return getRestaurants().find { it.getName() == id }
    }
}