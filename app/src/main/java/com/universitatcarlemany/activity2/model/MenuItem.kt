package com.universitatcarlemany.activity2.model

class MenuItem(
    private val id: Int,
    private val name: String,
    price: Double,
    private val description: String,
    private val image: String,
    private var units: Int,
    private val restaurant: Restaurant
) {
    private var _price = price

    init {
        // Check if the price is a positive number
        if (price < 0) {
            throw IllegalArgumentException("Price must be a positive number")
        }

        if (units < 0) {
            throw IllegalArgumentException("Units must be a positive number")
        }

        setPrice(price)
    }

    fun getId(): Int = id

    fun getName(): String = name

    fun getPrice(): Double = _price

    private fun setPrice(value: Double) {
        _price = Math.round(value * 100.0) / 100.0
    }

    fun getDescription(): String = description

    fun getImage(): String = image

    fun getUnits(): Int = units

    fun addUnits(units: Int) {
        this.units += units
    }

    fun decUnits() {
        this.units--
    }

    fun isAvailable(): Boolean {
        return units > 0
    }

    fun getRestaurant(): Restaurant = restaurant
}
