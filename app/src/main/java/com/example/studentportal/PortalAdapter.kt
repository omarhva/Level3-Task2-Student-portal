package com.example.studentportal

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

/**
 * @author Omar Mulla Ibrahim
 * Student Nr 500766035
 */

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // get the title and url 
        fun bind(portal: Portal) {
            itemView.tvTitel.text = portal.titel
            itemView.tvUrl.text = portal.url
            itemView.setOnClickListener {
                val uri = Uri.parse(portal.url)
                val intents = Intent(Intent.ACTION_VIEW, uri)
                val bundle = Bundle()
                bundle.putBoolean("new_window", true)
                intents.putExtras(bundle)
                var context: Context = itemView.context
                context.startActivity(intents)

            }
        }
    }

    /**
     * Creates and returns a ViewHolder object, inflating a
     * standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }
}
