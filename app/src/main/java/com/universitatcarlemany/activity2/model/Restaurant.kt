package com.universitatcarlemany.activity2.model

import java.time.LocalTime

class Restaurant(
    private val id: Int,
    private val name: String,
    private val image: String,
    private val address: String,
    private val openingTime: LocalTime,
    private val closingTime: LocalTime
) {
    private val menu = Menu()

    fun getId(): Int = id

    fun getName(): String = name

    fun getImage(): String = image

    fun getAddress(): String = address

    fun getOpeningTime(): LocalTime = openingTime

    fun getClosingTime(): LocalTime = closingTime

    fun getMenu(): Menu = menu
}