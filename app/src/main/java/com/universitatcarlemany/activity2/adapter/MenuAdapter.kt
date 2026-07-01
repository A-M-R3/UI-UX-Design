package com.universitatcarlemany.activity2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.universitatcarlemany.activity2.R
import com.universitatcarlemany.activity2.model.MenuItem

class MenuAdapter(
    private val menuItems: List<MenuItem>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNameText: TextView = view.findViewById(R.id.itemNameText)
        val itemPriceText: TextView = view.findViewById(R.id.itemPriceText)
        val addButton: Button = view.findViewById(R.id.addButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = menuItems[position]
        holder.itemNameText.text = item.getName()
        holder.itemPriceText.text = item.getPrice().toString()
    }

    override fun getItemCount() = menuItems.size
}