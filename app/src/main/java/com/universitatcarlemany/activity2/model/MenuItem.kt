package com.universitatcarlemany.activity2.model

class MenuItem(
    private val id: Int,
    private val name: String,
    private val price: Double,
    private val description: String,
    private val image: String,
    private var units: Int
) {
    fun getId(): Int = id

    fun getName(): String = name

    fun getPrice(): Double = price

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
}
