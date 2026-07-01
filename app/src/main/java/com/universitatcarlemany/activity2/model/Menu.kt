package com.universitatcarlemany.activity2.model

class Menu(
    private var allergies: String = "",
    private val items: MutableList<MenuItem> = mutableListOf()
) {
    fun getAllergies(): String {
        return allergies
    }

    fun setAllergies(allergies: String) {
        this.allergies = allergies
    }

    fun addItem(item: MenuItem) {
        items.add(item)
    }

    fun removeItem(item: MenuItem) {
        items.remove(item)
    }

    fun getAllItems(): List<MenuItem> {
        return items
    }
}
