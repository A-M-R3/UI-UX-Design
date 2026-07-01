package com.universitatcarlemany.activity2.model

class RestaurantResponse(
    private val restaurants: List<Restaurant>
) {
    fun getRestaurants(): List<Restaurant> = restaurants
}